package edu.iss.caps.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import edu.iss.caps.model.Loginrole;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.Studentgrade;
import edu.iss.caps.model.User;
import edu.iss.caps.service.CourseinfoService;
import edu.iss.caps.service.DepartmentService;
import edu.iss.caps.service.FacultyService;
import edu.iss.caps.service.LoginroleService;
import edu.iss.caps.service.StudentService;
import edu.iss.caps.service.StudentgradeService;
import edu.iss.caps.service.UserService;
import edu.iss.caps.validator.CourseinfoValidator;
//import edu.iss.caps.model.Student;
import edu.iss.caps.validator.DepartmentValidator;
import edu.iss.caps.validator.FacultyValidator;

@Controller
@RequestMapping(value = "/AdminEnrol")
public class AdminEnrolmentController {

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
	private StudentgradeService gradeService;
	
	Properties mailServerProperties;
	Session getMailSession;
	MimeMessage generateMailMessage;

	@InitBinder("department")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(dValidator);
	}

	@InitBinder("courseInfo")
	private void initCourseinfoBinder(WebDataBinder binder) {
		binder.addValidators(courseValidator);
	}

	@InitBinder("faculty")
	private void initFacultyBinder(WebDataBinder binder) {
		binder.addValidators(fValidator);
	}

	@RequestMapping(value = "/manageEnrolment", method = RequestMethod.GET)
	public ModelAndView studListManage(Model model, HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/enrolManage/selectCourse");
		mav.addObject("clist", courseService.findAllActiveCourses());
		return mav;
	}

	@RequestMapping(value = "/selectStudent", method = RequestMethod.POST)
	public ModelAndView selectStudent(Model model, HttpSession session, HttpServletRequest request) {
		int courseId = Integer.parseInt(request.getParameter("course-select"));
		ModelAndView mav = new ModelAndView("adminPage/adminRole/enrolManage/enroleStudent");
		ArrayList<Studentgrade> enrolStstus = gradeService.getStudentGradeByCourse(courseId);
		ArrayList<Student> students = sservice.findAllStudents();
		String crsName = courseService.findCourseNameByID(courseId);
		mav.addObject("enrolStstus", enrolStstus);
		mav.addObject("students", students);
		mav.addObject("courseId", courseId);
		mav.addObject("crsName", crsName);
		return mav;
	}

	@RequestMapping(value = "/student-enrole-admin/{studentId}/{courseId}", method = RequestMethod.POST)
	public ModelAndView studentEnroleAdmin(Model model, HttpSession session, @PathVariable String studentId,
			@PathVariable String courseId) throws AddressException, MessagingException {
		Student stu = sservice.findOneStudent(Integer.parseInt(studentId));
		Courseinfo crs = courseService.findCourseinfo(Integer.parseInt(courseId));
		Studentgrade enrolment = new Studentgrade();
		ArrayList<Studentgrade> grades = gradeService.viewEnrolmentByCourseID(Integer.parseInt(courseId));
		enrolment.setCompletionStatus("Enroled");
		enrolment.setCourseID(crs);
		enrolment.setEnrolledDate(new Date());
		enrolment.setStudentID(stu);
		if (crs.getMaxClassSize() < grades.size()) {
			return null;
		} else {
			Studentgrade newEnr = gradeService.createEnrolment(enrolment);
			String message = "You have been enroled to course "+crs.getCourseName()+" successfully!!";
			String mailId = stu.getEmail();
			this.sendMailFunction(mailId, message);
			return new ModelAndView("adminPage/adminRole/enrolManage/enroleStudent");
		}
	}

	@RequestMapping(value = "/student-request-grant/{courseId}/{studentId}", method = RequestMethod.POST)
	public ModelAndView studentRequestGrant(Model model, HttpSession session, @PathVariable String courseId,
			@PathVariable String studentId) throws AddressException, MessagingException {
		Courseinfo crs = courseService.findCourseinfo(Integer.parseInt(courseId));
		Student student = sservice.findOneStudent(Integer.parseInt(studentId));
		Studentgrade enrolment = gradeService.findGradeBySidCid(student, crs);
		ArrayList<Studentgrade> grades = gradeService.viewEnrolmentByCourseID(Integer.parseInt(courseId));
		if (crs.getMaxClassSize() < grades.size()) {
			return null;
		} else {
			enrolment.setCompletionStatus("Enroled");
			Studentgrade newEnr = gradeService.createEnrolment(enrolment);
			String message = "The request for the enrolment of course "+crs.getCourseName()+" has been approved";
			String mailId = student.getEmail();
			this.sendMailFunction(mailId, message);
			return new ModelAndView("adminPage/adminRole/enrolManage/enroleStudent");
		}
	}

	@RequestMapping(value = "/enrol-student-deny/{courseId}/{studentId}", method = RequestMethod.POST)
	public ModelAndView enrolStudentDeny(Model model, HttpSession session, @PathVariable String courseId,
			@PathVariable String studentId) throws AddressException, MessagingException {
		Courseinfo crs = courseService.findCourseinfo(Integer.parseInt(courseId));
		Student student = sservice.findOneStudent(Integer.parseInt(studentId));
		Studentgrade enrolment = gradeService.findGradeBySidCid(student, crs);
		ArrayList<Studentgrade> grades = gradeService.viewEnrolmentByCourseID(Integer.parseInt(courseId));
		enrolment.setCompletionStatus("Failed");
		Studentgrade newEnr = gradeService.createEnrolment(enrolment);
		
		String message = "Sorry you are not eligible for this course";
		String mailId = student.getEmail();
		this.sendMailFunction(mailId, message);
		
		return new ModelAndView("adminPage/adminRole/enrolManage/enroleStudent");
	}
	
	
	
	public String sendMailFunction(String tomail,String message) throws AddressException, MessagingException {
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(tomail));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("mailtoakjn@gmail.com"));
		generateMailMessage.setSubject("Greetings ");
		String emailBody = message + "<br><br> Regards, <br>Team 3";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "team3.iss.2016@gmail.com", "passwordpassword3");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();

		return "Result";

	}

}
