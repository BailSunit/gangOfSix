package inventory.csye7374.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import inventory.csye7374.config.service.facade.ItemServiceFacade;
import inventory.csye7374.config.service.facade.OrderServiceFacade;
import inventory.csye7374.model.Item;
import inventory.csye7374.model.Order;
import inventory.csye7374.model.OrderPlaced;
import inventory.csye7374.model.User;

@Controller
public class ItemListController {

	@Autowired
	private ItemServiceFacade itemServiceFacade;

	@Autowired
	private OrderServiceFacade orderServiceFacade;

	@RequestMapping(value = "/itemList", method = RequestMethod.POST)
	public ModelAndView backAction(HttpServletResponse response, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("customer") == null)
			return new ModelAndView("redirect:customerLogin");
		return new ModelAndView("redirect:itemList");
	}

	@RequestMapping(value = "/itemList", method = RequestMethod.GET)
	public ModelAndView customerLogin(HttpServletResponse response, HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("customer") == null)
			return new ModelAndView("redirect:customerLogin");
		List<Item> itemList = itemServiceFacade.returnItemList();
		return new ModelAndView("itemList", "itemList", itemList);
	}

	@RequestMapping(value = "/placeOrder")
	public ModelAndView placeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);

		List<Item> itemList = itemServiceFacade.returnItemList();
		HashMap<String, Item> itemMap = new HashMap<>();
		Set<String> orderList = request.getParameterMap().keySet();
		List<Order> orders = new ArrayList<>();
		for (Item item : itemList) {
			itemMap.put(item.getSlNo(), item);
		}

		User user = (User) session.getAttribute("customer");
		if (user == null)
			return new ModelAndView("redirect:customerLogin");
		for (String orderId : orderList) {
			if (itemMap.containsKey(orderId)) {
				Item item = itemMap.get(orderId);
				Order order = new Order();
				UUID id = UUID.randomUUID();
				order.setOrderId(id);
				order.setCurrentState(new OrderPlaced(order));
				order.setItem(item);
				order.setCustomerName(user.getUsername());
				order.setQuantity(1);
				orders.add(order);
				item.setAvailable(item.getAvailable() - 1);
				itemMap.replace(orderId, item);
			}
		}

		itemServiceFacade.changeInventoryCount(new ArrayList<Item>(itemMap.values()));
		orderServiceFacade.addOrders(orders);
		return new ModelAndView("orderPage", "orders", orders);
	}

}
