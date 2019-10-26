<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Homepage</title>
<link rel="stylesheet" type="text/css" href="gladiator.css">
</head>

<body bgcolor="#f1f1f1">
<div class="abc">
<img src="logo4.jpg">
  <a href="">Home</a>
  <a href="">About Us </a>
  <a href="">Contact Us</a>
  <a href="" style="float:right">Login</a>
  <a href="" style="float:right">Register</a>
</div>
<br><br><br>

<center>
<div class="homepage">  

<form action="selectreportexam.jsp" method="post"><input type="submit" class="button report" name="butn" value='View Report'></form>
<br><br><br>
<form action="selectexam.jsp" method="post"><input type="submit" class="button new" name="butn" value='New Exam'></form></div>
</center>



</body>
</html>