package edu.iss.caps.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.caps.model.Courseinfo;
import edu.iss.caps.model.Studentgrade;
import edu.iss.caps.model.User;
import edu.iss.caps.service.LecturerService;
import edu.iss.caps.service.StudentgradeService;
import edu.iss.caps.service.UserService;

@Controller
@RequestMapping(value = "/Lecturer")
public class LecturerController {
	
	@Autowired
	private UserService uservice;
	
	@Autowired
	private LecturerService lecturerservice;
	
	@Autowired
	private StudentgradeService sgservice;
	
	public int getLecturerId(HttpSession session){
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		return us.getGeneralID();
	}

	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String indexPage(Model model, HttpSession session) {
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
	
	@RequestMapping(value = "/viewMyCourses", method = RequestMethod.GET)
	public ModelAndView showLecturer(HttpSession session) {
		int lectId = this.getLecturerId(session);
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/coursebylecturer");
		Collection<Courseinfo> clist = lecturerservice.getCourseByLecturerID(lectId).getCourseinfoCollection();
		mav.addObject("clist", clist);
		return mav;
	}
	
	@RequestMapping(value = "/gradebycourse/{id}", method = RequestMethod.GET)
	public ModelAndView showGradeByClass(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/gradebycourse");
		ArrayList<Studentgrade> glist = sgservice.getStudentGradeByCourse(id);
		mav.addObject("glist", glist);
		return mav;
	}
	
	@RequestMapping(value = "/gradestudent", method = RequestMethod.GET)
	public ModelAndView ModelAndView (@RequestParam("enrolmentID") int enrolmentID) {
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/gradestudent");
		Studentgrade glist = sgservice.gradeStudent(enrolmentID);
		mav.addObject("glist", glist);
		return mav;
	}
	
	@RequestMapping(value = "/updategrade", method = RequestMethod.POST)
	public ModelAndView updateStudentGrade(@RequestParam("newgrade") String grade, @RequestParam("enrolmentID") int enrolmentID, @RequestParam("courseID") int courseID) {
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/gradebycourse");
		sgservice.updateStudentGrade(grade, enrolmentID);
		ArrayList<Studentgrade> glist = sgservice.getStudentGradeByCourse(courseID);
		mav.addObject("glist", glist);
		return mav;
	}
	
	@RequestMapping(value = "/enrolbycourse/{id}", method = RequestMethod.GET)
	public ModelAndView showEnrolment(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/enrolbycourse");
		ArrayList<Studentgrade> sment = sgservice.viewEnrolmentByCourseID(id);
		mav.addObject("sment", sment);		
		return mav;
	}
	
	@RequestMapping(value = "/studperf/{id}", method = RequestMethod.GET)
	public ModelAndView showPerformance(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/studperf");
		ArrayList<Studentgrade> sperf = sgservice.viewPerformanceByStudentID(id);
		mav.addObject("courseID",id);
		mav.addObject("sperf", sperf);
		return mav;
	}
	
	@RequestMapping(value="/gradeStds", method=RequestMethod.GET)
	public ModelAndView gradeStds(HttpSession session){
		int lectId = this.getLecturerId(session);
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/gradeCourseMenu");
		Collection<Courseinfo> clist = lecturerservice.getCourseByLecturerID(lectId).getCourseinfoCollection();
		mav.addObject("clist", clist);
		return mav;
	}
	
	@RequestMapping(value="/viewEnrlmnt", method=RequestMethod.GET)
	public ModelAndView viewEnrl(HttpSession session){
		int lectId = this.getLecturerId(session);
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/viewPerformanceMenu");
		Collection<Courseinfo> clist = lecturerservice.getCourseByLecturerID(lectId).getCourseinfoCollection();
		mav.addObject("clist", clist);
		return mav;
	}
}
