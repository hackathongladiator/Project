package com.lti.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.Entity;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.dao.QuestionDao;

import com.lti.entity.Question;
import com.lti.entity.Report;
import com.lti.entity.Student;
import com.lti.service.StudentService;
import com.lti.service.QuestionService;
import com.lti.service.ReportService;

@Controller
public class StudentController {
	@Resource
	private StudentService studentService;
	@Resource
	private QuestionService questionService;
	@Resource
	private ReportService reportService;
static int qnno=0,qnid,answer,id=1;
static String name,exam;
 
 
Report rep=new Report();
Report studreport=new Report();

List<Question> questions;


	
	@RequestMapping(path = "/registration.lti")
	//public String register(HttpServletRequest request) {
	//public String register(@RequestParam("name") String name, @RequestParam("email") String email, ...) {
	public String registration(Student student) {
		studentService.registration(student);
		return "confirmation.jsp";
	}
	
	@RequestMapping(path = "/login.lti")
	//public String register(HttpServletRequest request) {
	//public String register(@RequestParam("name") String name, @RequestParam("email") String email, ...) {
	public String registration(@RequestParam("email") String email, @RequestParam("password") String password,  Map model, ModelMap uname) {
		Student student = studentService.get(email,password);
		model.put("student", student);
		 name=student.getName();
		 uname.addAttribute("name",name);
		//System.out.println(student);
		return "userdash.jsp";
	}
	
	/*@RequestMapping(path = "/test.lti")
	//public String register(HttpServletRequest request) {
	//public String register(@RequestParam("name") String name, @RequestParam("email") String email, ...) {
	public String questnNo(@RequestParam("id") String qnNo,  Map model) {
		Question question = questionService.get(qnNo);
		model.put("question", question);
		//System.out.println(student);
		return "profile.jsp";*/
	
/*		@RequestMapping(path = "/test1.lti")
		//public String register(HttpServletRequest request) {
		//public String register(@RequestParam("name") String name, @RequestParam("email") String email, ...) {
		public String questnNo(@RequestParam("number") int id,  Map model) {
			//return questionService.get(id);
			Question question= questionService.get(id);
		    model.put("question", question);
		     return "confirmation.jsp";
			//System.out.println("hi");
			//return questionService.get(qnNo);
		}*/
		
		  @RequestMapping(path="/exam.lti")
		  public String questnNo(@RequestParam("butn") String butn, Map model,ModelMap uname) {
			  exam=butn;
			  System.out.println(qnno);
			  questions= questionService.get(butn);
			    Question question=questions.get(qnno);
			    qnid=question.getId();
			    model.put("qn",question);
			    uname.addAttribute("name",name);
			    /*model.put("obj", obj);*/
			    return "test.jsp";
		  	}
		  
		  @RequestMapping(path="/test.lti")
		  public String questNo(@RequestParam("opt") String opt, Map model,ModelMap ans) {
/*			  if(opt.equals(null))
			  {
				  opt="0";
			  }*/
			    answer=(Integer)questionService.calc(exam,opt,qnid);
			    String count=""+answer;
			    System.out.println("count"+count);
			    String examtype=exam;
			    System.out.println(examtype);
			    String uname=name;
			    System.out.println(uname);
			    qnno++;
				System.out.println(qnno);
			  	Question question=questions.get(qnno);
			    qnid=question.getId();
			    model.put("qn",question);
			    ans.addAttribute("count",count);
			    ans.addAttribute("name",uname);
			    ans.addAttribute("exam",examtype);
			    
			    if(qnno<10)
			    return "test.jsp";
			    else {
			    
			    	rep.setId(id++);
			    	rep.setScore(count);
			    	rep.setExamtype(examtype);
			    	rep.setName(uname);
				    reportService.report(rep);
			      	if(answer>6)
			      	{	ans.addAttribute("result","Pass");
			    	return "score.jsp";}
			   	   	else
			   	 {	ans.addAttribute("result","Fail");
		    	     return "score.jsp";
			    }
	    }
		  }
		  
		  
		  @RequestMapping(path="/proceed.lti")
		  public String Result(@RequestParam("butn") String butn, ModelMap ans) {
			 ans.addAttribute("name",name);
		  if(answer>6){
	      	ans.addAttribute("display","Congratulations!! You may now proceed to give other tests.");
	    	return "report.jsp";}
		  	
		  	else {
		    ans.addAttribute("display","Sorry! Try again later.");
		  	return "report.jsp";}
}

		  
		  @RequestMapping(path="/report.lti")
		  public String report(@RequestParam("examreport") String examreport,Map model,ModelMap uname) {
			  
			  String username=name;
			  studreport= reportService.get(username,examreport);
			  
			  String studname=studreport.getName();
			  String studtype=studreport.getExamtype();
			  String studresult=studreport.getScore();
			  uname.addAttribute("studname", studname);
			  uname.addAttribute("studtype", studtype);
			  uname.addAttribute("studresult", studresult);
		    /*model.put("obj", obj);*/
			    return "reportdisplay.jsp";
		  	}
		  
/*@RequestMapping(path="/excel.lti")
public void Excel(@RequestParam("myFile") String myFile) throws IOException {
	System.out.println(myFile);
}
*/
}
/*		  @RequestMapping(path="/css.lti")
		  public String questnNos(@RequestParam("butn") String butn, Map model) {
			  	qnno++;
				CssQuestion questions= cssquestionService.get(qnno);
			    model.put("question", questions);
			    model.put("obj", obj);
			    return "test.jsp";
		  	}
		  
		  @RequestMapping(path="/test1.lti")
		  public String questnNos(@RequestParam("butn") String butn,@RequestParam("opt") String opt, Map model,ModelMap ans) {
			    int answer=(Integer)cssquestionService.calc(qnno,opt);
			    String count=""+answer;
			    
			  	qnno++;
				CssQuestion questions= cssquestionService.get(qnno);
			    model.put("question", questions);
			    ans.addAttribute("count",count);
			    if(qnno<=10)
			    return "test.jsp";
			    else {
			      	if(answer>6)
			    	return "score.jsp";
			   	   	else
		    	return "profile2.jsp";
			    }
	    }*/
		  
		  
		  

			    
    

