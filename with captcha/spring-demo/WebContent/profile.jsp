<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Gladiator.css">
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<div class="abc">
<img src="logo4.jpg">
  <a href="index.jsp">Home</a>
  <a href="about.jsp">About Us </a>
  <a href="contact.jsp">Contact Us</a>
</div>
<h1>Login successful!</h1>
<h2>Name: </h2><center>${ student.name } </center>
<h2>Email Id: </h2><center>${ student.email } </center>
<h2>Mobile No: </h2><center>${ student.mobile } </center>
<h2>City: </h2><center>${ student.city } </center>
<h2>Date of Birth: </h2><center>${ student.dob } </center>
<center><a href="SelectExam.jsp" style="text-decoration:none" class="button">Proceed to Exam</a></center>
</body>
</html>