package inventory.csye7374.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemListController {

	@RequestMapping(value="/itemList")
	public ModelAndView customerLogin(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
}
