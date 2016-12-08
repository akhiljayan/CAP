package edu.iss.caps.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.caps.model.Department;
import edu.iss.caps.model.Faculty;
import edu.iss.caps.model.Loginrole;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.User;
import edu.iss.caps.service.DepartmentService;
import edu.iss.caps.service.FacultyService;
import edu.iss.caps.service.LoginroleService;
import edu.iss.caps.service.StudentService;
import edu.iss.caps.service.UserService;
//import edu.iss.caps.model.Student;

@Controller
@RequestMapping(value = "/Admin")
public class AdminController {

	@Autowired
	private UserService uservice;

	@Autowired
	private StudentService sservice;

	@Autowired
	private LoginroleService lrservice;

	@Autowired
	private DepartmentService dservice;

	@Autowired
	private FacultyService fservice;

	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String indexPage(Model model, HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		int id = us.getUser().getUserID();
		User logedInUser = uservice.findOneById(id);
		if (logedInUser != null && us.getSessionId() != null) {
			return "adminPage/adminIndex";
		} else {
			return "noAccess";
		}
	}

	@RequestMapping(value = "/studListManage", method = RequestMethod.GET)
	public ModelAndView studListManage(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/studMang/listStudents");
		mav.addObject("slist", sservice.findAllStudents());
		return mav;
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView addStudentForm(Model model, HttpSession session, Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/studMang/addStudentForm");

		mav.addObject("departments", dservice.findAllDepartments());
		mav.addObject("roles", lrservice.findAllRoles());
		mav.addObject("faculties", fservice.findAllFaculty());
		// map.put("user", new User());
		map.put("student", new Student());
		// mav.addObject("user", new User());
		// mav.addObject("student", new Student());
		return mav;
	}

	@RequestMapping(value = "/newStudentPersist", method = RequestMethod.POST)
	public String newStudentPersist(@ModelAttribute("Student") Student student, BindingResult result, Model model,
			HttpSession session, HttpServletRequest request) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		User createdUser = us.getUser();
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		int roleId = Integer.parseInt(role);
		Loginrole rlobj = lrservice.findOneById(roleId);
		user.setCreatedBy(createdUser);
		user.setPassword(password);
		user.setUsername(username);
		user.setRoleID(rlobj);
		User newUser = uservice.createUser(user);
		
		Department dpt = dservice.findOneById(Integer.parseInt(request.getParameter("student-department")));
		Faculty facl = fservice.finfOneById(Integer.parseInt(request.getParameter("student-faculty")));
		
		student.setStudentFacultyID(facl);
		student.setStudentDepartmentID(dpt);		
		student.setUserID(newUser);
		sservice.createStudent(student);

		return "redirect:/Admin/announcement";
	}

	@RequestMapping(value = "/editStudent/{id}", method = RequestMethod.GET)
	public ModelAndView editStudent(@PathVariable String id, @ModelAttribute Student student, Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/studMang/editStudentForm");
		//ModelAndView mav = new ModelAndView("list-students");
		Student studentObj = sservice.findOneStudent(Integer.parseInt(id));
		mav.addObject("departments", dservice.findAllDepartments());
		mav.addObject("roles", lrservice.findAllRoles());
		mav.addObject("faculties", fservice.findAllFaculty());
		mav.addObject("user",studentObj.getUserID());
		mav.addObject("ss",Integer.parseInt(id));
		mav.addObject("student",studentObj);
		//map.put("student", stud);
		return mav;
	}
	
	@RequestMapping(value = "/editStudentPersist/{id}", method = RequestMethod.POST)
	public String editStudentPersist(@ModelAttribute @Valid Student student, BindingResult result, @PathVariable Integer id, Model model,
			HttpSession session, HttpServletRequest request) throws ParseException {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		
		int userId = Integer.parseInt(request.getParameter("studentUserId"));
		User user = uservice.findOneById(userId);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		int roleId = Integer.parseInt(role);
		Loginrole rlobj = lrservice.findOneById(roleId);

		user.setPassword(password);
		user.setUsername(username);
		user.setRoleID(rlobj);
		User newUser = uservice.changeUser(user);
		
		Department dpt = dservice.findOneById(Integer.parseInt(request.getParameter("student-department")));
		Faculty facl = fservice.finfOneById(Integer.parseInt(request.getParameter("student-faculty")));
		
		Student std = sservice.findOneStudent(id);
		
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy"); 
		
		std.setAddress(request.getParameter("address"));
		std.setDob(df.parse(request.getParameter("dob")));
		std.setEmail(request.getParameter("email"));
		std.setGender(request.getParameter("gender"));
		std.setMatricDate(df.parse(request.getParameter("matricDate")));
		std.setStatus(request.getParameter("status"));
		std.setStudentName(request.getParameter("studentName"));
		
		std.setStudentFacultyID(facl);
		std.setStudentDepartmentID(dpt);
		std.setUserID(newUser);
		sservice.changeStudent(std);		
		return "redirect:/Admin/announcement";
	}
	
	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.POST)
	public String deleteRole(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
		Student std = sservice.findOneStudent(id);
		User user = std.getUserID();		
		sservice.removeStudent(std);
		uservice.removeUser(user);
		return "list-students";
	}

}
