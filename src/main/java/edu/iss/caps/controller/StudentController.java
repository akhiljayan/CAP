package edu.iss.caps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.caps.model.User;
import edu.iss.caps.service.StudentgradeService;
import edu.iss.caps.service.UserService;

@Controller
@RequestMapping(value = "/Student")
public class StudentController {
	
	@Autowired
	private UserService uservice;
	
	@Autowired
	private StudentgradeService gradeService;
	
	public int getStudentId(HttpSession session){
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		return us.getGeneralID();
	}
	
	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String indexPage(Model model, HttpSession session) {
		//return "redirect:/Student/announcement";
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		int id = us.getUser().getUserID();
		String role = us.getUser().getRoleID().getRole();
		User logedInUser = uservice.findOneById(id);
		if (logedInUser != null && us.getSessionId() != null) {
			return "adminPage/adminIndex";
		} else {
			return "noAccess";
		}
	}
	
	@RequestMapping(value = "/viewGrades", method = RequestMethod.GET)
	public ModelAndView ListStudentPage(HttpSession session) {
		int currentStudentId = this.getStudentId(session);
		ModelAndView mav = new ModelAndView("adminPage/studRole/grade-list");
		mav.addObject("gradelist", gradeService.findGradeBySid(currentStudentId));
		return mav;
	}
	
}
