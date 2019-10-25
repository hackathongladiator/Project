<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Gladiator.css">
</head>
<body>
<div class="abc">
<img src="logo4.jpg">
  <a href="index.jsp">Home</a>
  <a href="about.jsp">About Us </a>
  <a href="contact.jsp">Contact Us</a>
</div>
		<form action="registration.lti" method="get" class="container">

		<div id = "form1" style="font-family: Arial;font-size: 15px;"><p style="font-size:20px; font-weight:500;"><center><h1>REGISTRATION</h1></center></p>

		<STRONG>Full Name:</strong> <input type="text" class="textfields" placeholder="Firstname Lastname" id="name" name="name" required><br>

		<strong>Email:</strong> <input type="email"class="textfields" placeholder="xyz@abc.com" id="email" name="email" required><br>

		<strong>Password:</strong> <input type="password" class="textfields" placeholder="Password" id="password" title="Six or more characters" name="password" minlength="6" required><br>

		<strong>Mobile:</strong> <input type="text"class="textfields" placeholder="91xxxxxxxx" id="mob" name="mobile" minlength="10" maxlength="10" required><br>

		<strong>City:</strong> <select required class="textfields" name="city">
  			<option value="Mumbai">Mumbai</option>
  			<option value="Pune">Pune</option>
  			<option value="Bangalore">Bangalore</option>
  			<option value="Chennai">Chennai</option>
		</select>

		<strong>Date of birth:</strong> <input type="date" class="textfields" id="dob" name="dob" required><br>
		
		
		
		
		<input type ="submit" value="submit" id="myBtn"> 
		</form>
	</body>
</html>
		