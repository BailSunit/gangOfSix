package inventory.csye7374.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import inventory.csye7374.config.legacy.UserService;
import inventory.csye7374.model.User;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/")
	public ModelAndView homeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/customerLogin", method = RequestMethod.GET)
	public ModelAndView customerLogin(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("customer", new User());
		return new ModelAndView("customerLogin");
	}
	
	@RequestMapping(value="/customerLogin", method = RequestMethod.POST)
	public ModelAndView customerLoginSubmit(@ModelAttribute("customer") User user, HttpServletResponse response, HttpServletRequest request) throws IOException{
		if(userService.validateUser(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", user);
			return new ModelAndView("redirect:itemList");
		}
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
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletResponse response, HttpSession session) throws IOException{
		session.removeAttribute("customer");
		return new ModelAndView("home");
	}
}
