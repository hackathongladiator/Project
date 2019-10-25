package com.lti.controller;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.dao.ChangePasswordDao;
import com.lti.entity.Student;
import com.lti.service.ChangePasswordService;
import com.lti.service.StudentService;
import com.mail.Sendmail;

@Controller
public class StudentController {

	@Resource
	private StudentService studentService;
	@Resource
	private ChangePasswordService changePasswordService;
	
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
	public String registration(@RequestParam("email") String email, @RequestParam("password") String password, Map model) {
		Student student = studentService.get(email, password);
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
	public String change(@RequestParam("email") String email, @RequestParam("city") String city, @RequestParam("password") String password) 
	{
		changePasswordService.changepassword(email,city,password);
		return "success.jsp";
	}
}
