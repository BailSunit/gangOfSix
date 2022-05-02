package inventory.csye7374.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import inventory.csye7374.config.service.facade.OrderServiceFacade;
import inventory.csye7374.model.Order;
import inventory.csye7374.model.User;

@Controller
public class OrderListController {

	@Autowired
	private OrderServiceFacade orderServiceFacade;

	@RequestMapping(value = "/pastOrder")
	public String customerLogin(HttpServletResponse response, HttpSession session, Model model) throws IOException {
		// Get User ID
		User user = (User) session.getAttribute("customer");
		if (user == null)
			return "redirect:customerLogin";
		List<Order> orders = orderServiceFacade.getOrdersByCustomerName(user.getUsername());
		model.addAttribute("orders", orders);
		return "orderList";
	}

	@RequestMapping(value = "/completeOrderList")
	public String completeOrderList(HttpServletResponse response, HttpSession session, Model model) throws IOException {
		// Get User ID
		User user = (User) session.getAttribute("admin");
		// if(user == null)
		// return "redirect:adminLogin";
		List<Order> orders = orderServiceFacade.getAllOrder();
		orderServiceFacade.setInProgress(orders);
		model.addAttribute("orders", orders);
		return "orderList";
	}

	@RequestMapping(value = "/updateOrder", method = RequestMethod.GET)
	public String updateOrderGet(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			Model model) throws IOException {
		List<Order> orders = orderServiceFacade.getAllOrder();
		List<Order> returnedList = new ArrayList<>();
		for (Order order : orders) {
			if (!order.getCurrentState().toString().equals("OrderComplete"))
				returnedList.add(order);
		}
		model.addAttribute("orders", returnedList);
		return "updateOrder";
	}

	@RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
	public String updateOrder(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			Model model) throws IOException {
		// Get User ID
		User user = (User) session.getAttribute("admin");
		// if(user == null)
		// return "redirect:adminLogin";
		Set<String> requestList = request.getParameterMap().keySet();
		List<Order> orders = orderServiceFacade.getRequestedOrders(requestList);
		orderServiceFacade.updateOrderStatus(orders);
		model.addAttribute("orders", orderServiceFacade.getAllOrder());
		return "redirect:updateOrder";
	}

}
