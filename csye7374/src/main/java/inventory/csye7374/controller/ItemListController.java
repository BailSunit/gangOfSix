package inventory.csye7374.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import inventory.csye7374.config.service.facade.ItemServiceFacade;
import inventory.csye7374.model.Item;
import inventory.csye7374.model.Order;
import inventory.csye7374.model.OrderPlaced;

@Controller
public class ItemListController {

	@Autowired
	private ItemServiceFacade itemServiceFacade;

	@RequestMapping(value = "/itemList", method=RequestMethod.GET)
	public ModelAndView customerLogin(HttpServletResponse response) throws IOException {
		List<Item> itemList = itemServiceFacade.returnItemList();
		return new ModelAndView("itemList", "itemList", itemList);
	}

	@RequestMapping(value = "/placeOrder")
	public ModelAndView placeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Item> itemList = itemServiceFacade.returnItemList();
		HashMap<String, Item> itemMap = new HashMap<>();
		Set<String> orderList = request.getParameterMap().keySet();
		List<Order> orders = new ArrayList<>();
		for (Item item : itemList) {
			itemMap.put(item.getSlNo(), item);
		}

		for (String orderId : orderList) {
			if (itemMap.containsKey(orderId)) {
				Item item = itemMap.get(orderId);
				Order order = new Order();
				order.setCurrentState(new OrderPlaced(order));
				order.setItem(item);
				order.setCustomer(orderId);
				orders.add(order);
				item.setAvailable(item.getAvailable() - 1);
				itemMap.replace(orderId, item);
			}
		}

		itemServiceFacade.changeInventoryCount(new ArrayList<Item>(itemMap.values()));
		return new ModelAndView("orderPage", "orders", orders);
	}

}
