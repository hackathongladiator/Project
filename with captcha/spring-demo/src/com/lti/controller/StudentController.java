package com.lti.controller;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.dao.ChangePasswordDao;
import com.lti.entity.Admin;
import com.lti.entity.Student;
import com.lti.service.AdminService;
import com.lti.service.ChangePasswordService;
import com.lti.service.StudentService;
import com.mail.Sendmail;

@Controller
public class StudentController {

	@Resource
	private StudentService studentService;
	@Resource
	private ChangePasswordService changePasswordService;
	@Resource
	private AdminService adminService;
	
	@RequestMapping(path = "/registration.lti")
	//public String register(HttpServletRequest request) {
	//public String register(@RequestParam("name") String name, @RequestParam("email") String email, ...) {
	public String registration(Student student) {
	//	System.out.println(student.getName());
		studentService.registration(student);
		return "confirmation.jsp";
	}
	
	@RequestMapping(path = "/searching.lti")
	//public String register(HttpServletRequest request) {
	//public String register(@RequestParam("name") String name, @RequestParam("email") String email, ...) {
	public String registration(@RequestParam("email") String email, @RequestParam("password") String password, Map model,ModelMap invalid) {
		Student student = studentService.get(email, password);
		if(student == null)
		{
			invalid.addAttribute("invalid","Invalid credentials. Please try again.");
			return "Login.jsp";
		}
		model.put("student", student);
		//System.out.println(student);
		return "profile.jsp";
	}
	
	@RequestMapping(path = "/sendmail.lti")
	public String mail(@RequestParam("email") String email, HttpServletRequest request, Model model) 
	{
		request.getSession().setAttribute("email", email);
		model.addAttribute("email");
		Sendmail sendmail = new Sendmail();
		sendmail.sendmail(email);
		//System.out.println(student);
		return "reset.jsp";
	}
	
	
	@RequestMapping(path = "/changepwd.lti")
	public String change(@RequestParam("email") String email, @RequestParam("city") String city, @RequestParam("password") String password, @RequestParam("dob") String dob) 
	{
		changePasswordService.changepassword(email,city,password, dob);
		return "success.jsp";
	}
	
	
	@RequestMapping(path = "/admin.lti")
	//public String register(HttpServletRequest request) {
	//public String register(@RequestParam("name") String name, @RequestParam("email") String email, ...) {
	public String adminlogin(@RequestParam("email") String email, @RequestParam("password") String password, Map model, ModelMap invalid) {
		Admin admin = adminService.get(email, password);
		if(admin == null)
		{
			invalid.addAttribute("invalid","Invalid credentials. Please try again.");
			return "adminlogin.jsp";
		}
		
		model.put("admin", admin);
		//System.out.println(student);
		return "admin.jsp";
	}
}
