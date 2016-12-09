package edu.iss.caps.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.caps.service.*;
import edu.iss.caps.controller.UserSession;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService uservice;
	
	@Autowired
	private LecturerService lservice;
	
	@Autowired
	private StudentService sservice;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String indexPage(Model model,HttpServletRequest request) {
		model.addAttribute("user", new User());
		UserSession us = new UserSession();
		us.setAdminFlag(false);
		model.addAttribute("session", us.getSessionId());
		return "homePage/homeIndex";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (user.getUsername() != null && user.getPassword() != null) {
			User u = uservice.authenticate(user.getUsername(), user.getPassword());
			us.setUser(u);
			us.setLogedIn(true);
			us.setSessionId(session.getId());
			us.setAdminFlag(true);
			if(u.getRoleID().getRole().equals("Student")){
				Student logedStudent = sservice.findOneByUserId(u);
				us.setGeneralID(logedStudent.getStudentID());
			}else if(u.getRoleID().getRole().equals("Lecturer")){
				
			}else{
				
			}
			mav = new ModelAndView("redirect:/home/redirect");
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		return mav;
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirectToPage(Model model,HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		String role = us.getUser().getRoleID().getRole();
		if(role.equals("Admin")){
			return "redirect:/Admin/announcement";
		}else if(role.equals("Lecturer")){
			return "redirect:/Lecturer/announcement";
		}else if(role.equals("Student")){
			return "redirect:/Student/announcement";
		}else{
			return "hamePage/noAccess";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/main";
	}

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView newCoursePage() {
		ModelAndView mav = new ModelAndView("list-users");
		mav.addObject("ulist", uservice.findAllUsers());
		return mav;
	}
	
	
	@RequestMapping(value = "/listLect", method = RequestMethod.GET)
	public ModelAndView newLecturPage() {
		ModelAndView mav = new ModelAndView("list-lectu");
		mav.addObject("llist", lservice.findAllLecturer());
		return mav;
	}
	

	
}
