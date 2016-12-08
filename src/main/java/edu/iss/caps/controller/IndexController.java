package edu.iss.caps.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(Model model,HttpServletRequest request) {
		return "redirect:/home/main";
	}

	
}
