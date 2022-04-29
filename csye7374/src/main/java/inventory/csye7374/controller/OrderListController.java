package inventory.csye7374.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import inventory.csye7374.config.service.facade.OrderServiceFacade;
import inventory.csye7374.model.Order;
import inventory.csye7374.model.User;

@Controller
public class OrderListController {

	@Autowired
	private OrderServiceFacade orderServiceFacade;
	
	@RequestMapping(value="/pastOrder")
	public ModelAndView customerLogin(HttpServletResponse response, HttpSession session, Model model) throws IOException{
		//Get User ID
		User user = (User) session.getAttribute("customer");
		List<Order> orders = orderServiceFacade.getOrdersByCustomerName(user.getUsername());
		model.addAttribute(orders);
		return new ModelAndView("orderList");
	}


}
