package edu.iss.caps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.caps.service.StudentService;

@Controller
@RequestMapping(value = "/Ajax")
public class AjaxController {
	
	
	@Autowired
	private StudentService sservice;
	
	@RequestMapping(value = "/search-students/{value}", method = RequestMethod.GET)
	public ModelAndView searchStudents(Model model, HttpSession session, @PathVariable String value) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/studMang/showStudentsList");
		if(value.equals("--")){
			mav.addObject("slist", sservice.findAllStudents());	
		}else{
			mav.addObject("slist", sservice.findStudentsBySearch(value));	
		}
		return mav;
	}
}
