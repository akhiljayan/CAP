package edu.iss.caps.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.caps.model.Courseinfo;
import edu.iss.caps.model.Department;
import edu.iss.caps.model.Faculty;
import edu.iss.caps.model.Lecturer;
import edu.iss.caps.model.Loginrole;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.User;
import edu.iss.caps.service.CourseinfoService;
import edu.iss.caps.service.DepartmentService;
import edu.iss.caps.service.FacultyService;
import edu.iss.caps.service.LecturerService;
import edu.iss.caps.service.LoginroleService;
import edu.iss.caps.service.StudentService;
import edu.iss.caps.service.UserService;
import edu.iss.caps.validator.CourseinfoValidator;
//import edu.iss.caps.model.Student;
import edu.iss.caps.validator.DepartmentValidator;
import edu.iss.caps.validator.FacultyValidator;

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
	
	@Autowired
	private DepartmentValidator dValidator;
	
	@Autowired
	private FacultyValidator fValidator;
	
	@Autowired
	private CourseinfoService courseService;
	
	@Autowired
	private CourseinfoValidator courseValidator;
	
	@Autowired
	private LecturerService lecService;
	
	@InitBinder("department")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(dValidator);
	}
	
	@InitBinder("courseInfo")
	private void initCourseinfoBinder(WebDataBinder binder){
		binder.addValidators(courseValidator);
	}
	
	@InitBinder("faculty")
	private void initFacultyBinder(WebDataBinder binder) {
		binder.addValidators(fValidator);
	}
	
	private void printPageDetails(PagedListHolder<Courseinfo> studentList) {
		System.out.println("curent page - productList.getPage() :" + studentList.getPage());
		System.out.println("Total Num of pages - productList.getPageCount :" + studentList.getPageCount());
		System.out.println("is First page - productList.isFirstPage :" + studentList.isFirstPage());
		System.out.println("is Last page - productList.isLastPage :" + studentList	.isLastPage());
	}

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
	public ModelAndView studListManage( Model model, HttpSession session, HttpServletRequest req) {
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
		Loginrole rlobj = lrservice.findOneById(3);
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

		return "redirect:/Admin/studListManage";
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
		
		User user = uservice.findOneById(student.getUserID().getUserID());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		int roleId = student.getUserID().getRoleID().getRoleID();//Integer.parseInt(role);
		Loginrole rlobj = lrservice.findOneById(roleId);

		user.setPassword(password);
		user.setUsername(username);
		user.setRoleID(rlobj);
		User newUser = uservice.changeUser(user);
		student.setUserID(newUser);
		sservice.changeStudent(student);		
		return "redirect:/Admin/studListManage";
	}
	
	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.POST)
	public String deleteRole(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
		Student std = sservice.findOneStudent(id);
		User user = std.getUserID();		
		sservice.removeStudent(std);
		uservice.removeUser(user);
		return "list-students";
	}

	@RequestMapping(value="/manageDepartment",method=RequestMethod.GET)
	public ModelAndView ListDepartmentPage(){
		ModelAndView mav = new ModelAndView("adminPage/adminRole/manageDept/department-list");
		mav.addObject("dlist",dservice.findAllDepartments());
		return mav;
	}
	
	@RequestMapping(value = "/createDepartment", method = RequestMethod.GET)
	public ModelAndView newDepartmentPage() {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/manageDept/department-new", "department", new Department());
		mav.addObject("dlist", dservice.findAllDepartments());
		mav.addObject("flist",fservice.findAllFaculty());
		return mav;
	}
	
	@RequestMapping(value = "/createDepartment",method=RequestMethod.POST)
	public ModelAndView createNewDepartment(@ModelAttribute @Valid Department department,BindingResult result,
			final RedirectAttributes redirectAttributes){
		if (result.hasErrors()){
			ModelAndView mav = new ModelAndView("adminPage/adminRole/manageDept/department-new");
			mav.addObject("flist",fservice.findAllFaculty());
			return mav;
		}
		ModelAndView mav = new ModelAndView();
		dservice.createDepartment(department);
		mav.setViewName("redirect:/Admin/manageDepartment");
		return mav;
	}
	
	@RequestMapping(value = "/editDepartment/{id}", method = RequestMethod.GET)
	public ModelAndView editDepartmentPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/manageDept/department-edit");
		Department department = dservice.findDepartment(id);
		mav.addObject("department", department);
		mav.addObject("dlist", dservice.findAllDepartments());
		mav.addObject("flist",fservice.findAllFaculty());
		return mav;
	}

	@RequestMapping(value = "/editDepartment/{id}", method = RequestMethod.POST)
	public ModelAndView editDepartment(@ModelAttribute @Valid Department department, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes) /*throws DepartmentNotFound*/ {
		if (result.hasErrors()){
			ModelAndView mav = new ModelAndView("adminPage/adminRole/manageDept/department-edit");
			mav.addObject("flist",fservice.findAllFaculty());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/Admin/manageDepartment");	
		dservice.changeDepartment(department);
		return mav;
	}
	
	@RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.POST)
	public String deleteDepartment(@PathVariable int id, final RedirectAttributes redirectAttributes){
		Department department = dservice.findDepartment(id);
		dservice.removeDepartment(department);
		return "list-students";
	}
	
	@RequestMapping(value="/manageFaculty",method=RequestMethod.GET)
	public ModelAndView ListFacultyPage(){
		ModelAndView mav = new ModelAndView("adminPage/adminRole/manageFaclty/faculty-list");
		mav.addObject("flist",fservice.findAllFaculty());
		return mav;
	}
	
	@RequestMapping(value = "/createFaculty", method = RequestMethod.GET)
	public ModelAndView newFacultyPage() {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/manageFaclty/faculty-new", "faculty", new Faculty());
		mav.addObject("flist", fservice.findAllFaculty());
		return mav;
	}
	
	@RequestMapping(value = "/createFaculty",method=RequestMethod.POST)
	public ModelAndView createNewFaculty(@ModelAttribute @Valid Faculty faculty,BindingResult result,
			final RedirectAttributes redirectAttributes){
		if (result.hasErrors()){
			return new ModelAndView("adminPage/adminRole/manageFaclty/faculty-new");
		}
		ModelAndView mav = new ModelAndView();	
		fservice.createFaculty(faculty);
		mav.setViewName("redirect:/Admin/manageFaculty");
		return mav;
	}
	
	@RequestMapping(value = "/editFaculty/{id}", method = RequestMethod.GET)
	public ModelAndView editFacultyPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/manageFaclty/faculty-edit");
		Faculty faculty = fservice.findFaculty(id);
		mav.addObject("faculty", faculty);
		mav.addObject("flist", fservice.findAllFaculty());
		return mav;
	}

	@RequestMapping(value = "/editFaculty/{id}", method = RequestMethod.POST)
	public ModelAndView editFaculty(@ModelAttribute @Valid Faculty faculty, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes) /*throws DepartmentNotFound*/ {
		if (result.hasErrors()){
			return new ModelAndView("adminPage/adminRole/manageFaclty/faculty-edit");
		}
		ModelAndView mav = new ModelAndView("redirect:/Admin/manageFaculty");	
		fservice.changeFaculty(faculty);
		return mav;
	}
	
	@RequestMapping(value = "/deleteFaculty/{id}", method = RequestMethod.POST)
	public String deleteFaculty(@PathVariable int id, final RedirectAttributes redirectAttributes){
		Faculty faculty = fservice.findFaculty(id);
		fservice.removeFaculty(faculty);
		return "adminPage/adminIndex";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value={"/manageCourse/{type}","/manageCourse"},method=RequestMethod.GET)
	public ModelAndView ListCoursePage(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req){
		
		PagedListHolder<Courseinfo> cList = null;
		String type = pathVariablesMap.get("type");
		
		if (null == type) {
			List<Courseinfo> courseList = courseService.findAllActiveCourses();
			cList = new PagedListHolder<Courseinfo>();
			cList.setSource(courseList);
			cList.setPageSize(5);
			req.getSession().setAttribute("courseList", cList);
			printPageDetails(cList);
		} else if ("next".equals(type)) {
			cList = (PagedListHolder<Courseinfo>) req.getSession().getAttribute("courseList");
			cList.nextPage();
		} else if ("prev".equals(type)) {
			cList = (PagedListHolder<Courseinfo>) req.getSession().getAttribute("courseList");
			cList.previousPage();
		} else {
			System.out.println("type:" + type);
			cList = (PagedListHolder<Courseinfo>) req.getSession().getAttribute("courseList");
			int pageNum = Integer.parseInt(type);
			cList.setPage(pageNum);
			printPageDetails(cList);
		}
		ModelAndView mav = new ModelAndView("adminPage/adminRole/courseMang/course-list");
		return mav;
	}
	
	@RequestMapping(value = "/createNewCourse", method = RequestMethod.GET)
	public ModelAndView newCoursePage() {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/courseMang/course-new", "courseInfo", new Courseinfo());
		mav.addObject("clist",courseService.findAllActiveCourses());
		mav.addObject("dlist",dservice.findAllDepartments());
		mav.addObject("flist",fservice.findAllFaculty());
		mav.addObject("lect",lecService.findAllLecturer());
		return mav;
	}
	
	@RequestMapping(value = "/createNewCourse",method=RequestMethod.POST)
	public ModelAndView createNewCourseinfo(@ModelAttribute @Valid Courseinfo courseInfo,BindingResult result,
			final RedirectAttributes redirectAttributes, HttpServletRequest request){
		if (result.hasErrors()){
			return new ModelAndView("adminPage/adminRole/courseMang/course-new");
		}
		ModelAndView mav = new ModelAndView();
		courseInfo.setCourseActiveStatus("Active");
		Courseinfo crs = courseService.createCourseinfo(courseInfo);
		
		Lecturer luct = lecService.findOneByLectId(Integer.parseInt(request.getParameter("lecturerId")));
//		LecturerCourse lc = new LecturerCourse();
//		lc.setCourseID(crs);
//		lc.setLecturerID(luct);
		mav.setViewName("redirect:/Admin/manageCourse");
		return mav;
	}
	
	@RequestMapping(value = "/editCourse/{id}", method = RequestMethod.GET)
	public ModelAndView editCoursesPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/courseMang/course-edit");
		Courseinfo courseInfo = courseService.findCourseinfo(id);
		mav.addObject("courseInfo", courseInfo);		
		mav.addObject("dlist",dservice.findAllDepartments());
		mav.addObject("flist",fservice.findAllFaculty());
		return mav;
	}

	@RequestMapping(value = "/editCourse/{id}", method = RequestMethod.POST)
	public ModelAndView editCourses(@ModelAttribute @Valid Courseinfo courseInfo, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes) /*throws DepartmentNotFound*/ {
		if (result.hasErrors()){
			return new ModelAndView("adminPage/adminRole/courseMang/course-edit");
		}
		ModelAndView mav = new ModelAndView("redirect:/Admin/manageCourse");
		courseService.changeCourseinfo(courseInfo);
		return mav;
	}
	
	@RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.POST)
	public String deleteCourse(@PathVariable int id, final RedirectAttributes redirectAttributes){
		
		
		Courseinfo courseInfo = courseService.findCourseinfo(id);
		courseInfo.setCourseActiveStatus("Inactive");
		courseService.changeCourseinfo(courseInfo);		
		return "adminPage/adminIndex";
	}
//====================================================================================================================	
	
	
	@RequestMapping(value = "/manageLecturer", method = RequestMethod.GET)
	public ModelAndView manageLecturer( Model model, HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/lectMang/listLecturer");
		List<Lecturer> lecList = lecService.findAllEmployedLecturers();
		mav.addObject("lecList", lecList);
		return mav;
	}

	

	@RequestMapping(value = "/addLecturer", method = RequestMethod.GET)
	public ModelAndView addLecturerForm(Model model, HttpSession session, Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/lectMang/addLecturerForm", "lecturer", new Lecturer());
		mav.addObject("flist",fservice.findAllFaculty());
		mav.addObject("dlist",dservice.findAllDepartments());
		return mav;
	}

	@RequestMapping(value = "/addLecturer", method = RequestMethod.POST)
	public ModelAndView addLecturerPersist(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			Model model, HttpSession session, final RedirectAttributes redirectAttributes,  HttpServletRequest request) {
		
		if (result.hasErrors()){
			return new ModelAndView("adminPage/adminRole/lectMang/addLecturerForm");
		}else{
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
			User createdUser = us.getUser();
			User user = new User();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Loginrole rlobj = lrservice.findOneById(2);
			user.setCreatedBy(createdUser);
			user.setPassword(password);
			user.setUsername(username);
			user.setRoleID(rlobj);
			User newUser = uservice.createUser(user);
			
			lecturer.setUserID(newUser);
			lecService.createLecturer(lecturer);
			
			ModelAndView mav = new ModelAndView();			
			mav.setViewName("redirect:/Admin/manageLecturer");
			return mav;
		}
	}

	@RequestMapping(value = "/editLecturer/{id}", method = RequestMethod.GET)
	public ModelAndView editLecturer(@PathVariable String id, @ModelAttribute Lecturer lecturer, Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/lectMang/editLecturerForm");
		Lecturer lecturerObj = lecService.findLecturer(Integer.parseInt(id));
		mav.addObject("departments", dservice.findAllDepartments());
		mav.addObject("faculties", fservice.findAllFaculty());
		mav.addObject("user",lecturerObj.getUserID());
		mav.addObject("lecturer",lecturerObj);
		return mav;
	}
	
	@RequestMapping(value = "/editLecturer/{id}", method = RequestMethod.POST)
	public ModelAndView editLecturerPersist(@ModelAttribute @Valid Lecturer lecturer, BindingResult result, @PathVariable Integer id, Model model,
			HttpSession session, HttpServletRequest request, final RedirectAttributes redirectAttributes) throws ParseException {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		if (result.hasErrors())
		{
			return new ModelAndView("adminPage/adminRole/lectMang/editLecturerForm");
		}else{
			User user = uservice.findOneById(lecturer.getUserID().getUserID());
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Loginrole rlobj = lrservice.findOneById(2);
			user.setPassword(password);
			user.setUsername(username);
			user.setRoleID(rlobj);
			User newUser = uservice.changeUser(user);
			lecturer.setUserID(newUser);
			lecService.changeLecturer(lecturer);	
			ModelAndView mav = new ModelAndView("redirect:/Admin/manageLecturer");
			return mav;
		}
	}
	
	@RequestMapping(value = "/deleteLecturer/{id}", method = RequestMethod.POST)
	public String deleteLecturer(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
		Lecturer lecturer = lecService.findLecturer(id);
		User user = lecturer.getUserID();		
		uservice.removeUser(user);
		lecturer.setStatus("Unemployed");
		lecturer.setUserID(null);
		lecService.changeLecturer(lecturer);
		return "redirect:/Admin/manageLecturer";
	}
	
	

}
