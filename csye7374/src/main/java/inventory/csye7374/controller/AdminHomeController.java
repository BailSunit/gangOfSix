package inventory.csye7374.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class AdminHomeController {

	@RequestMapping(value = "/orderList")
	public ModelAndView orderList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("admin") == null)
			return new ModelAndView("redirect:adminLogin");
		return new ModelAndView("orderList");
	}

	@RequestMapping(value = "/updateOrder")
	public ModelAndView updateOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("admin") == null)
			return new ModelAndView("redirect:adminLogin");
		return new ModelAndView("updateOrder");
	}

	@RequestMapping(value = "/checkInventory")
	public ModelAndView checkInventory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("admin") == null)
			return new ModelAndView("redirect:adminLogin");
		return new ModelAndView("checkInventory");
	}
}
