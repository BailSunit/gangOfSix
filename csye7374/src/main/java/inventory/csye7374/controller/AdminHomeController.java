package inventory.csye7374.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class AdminHomeController {
	
	
	@RequestMapping(value="/orderList")
	public ModelAndView orderList(HttpServletResponse response) throws IOException{
		return new ModelAndView("orderList");
	}
	
	@RequestMapping(value="/updateOrder")
	public ModelAndView updateOrder(HttpServletResponse response) throws IOException{
		return new ModelAndView("updateOrder");
	}
	
	@RequestMapping(value="/checkInventory")
	public ModelAndView checkInventory(HttpServletResponse response) throws IOException{
		return new ModelAndView("checkInventory");
	}
}
