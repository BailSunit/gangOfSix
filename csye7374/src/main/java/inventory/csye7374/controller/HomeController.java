package inventory.csye7374.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView customerLogin(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/customerLogin")
	public ModelAndView customerLogin(HttpServletResponse response) throws IOException{
		return new ModelAndView("customerLogin");
	}
	@RequestMapping(value="/adminLogin")
	public ModelAndView adminLogin(HttpServletResponse response) throws IOException{
		return new ModelAndView("adminLogin");
	}
	
	@RequestMapping(value="/adminHomePage")
	public ModelAndView adminHomePage(HttpServletResponse response) throws IOException{
		return new ModelAndView("adminHomePage");
	}
}
