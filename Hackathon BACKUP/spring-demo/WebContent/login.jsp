<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="gladiator.css">
</head>
<body>
<div class="abc">
<img src="logo4.jpg">
  <a href="">Home</a>
  <a href="">About Us </a>
  <a href="">Contact Us</a>
</div>
	<h3>
		Don't have an account?  <a href="">Register here.</a>
	</h3>
	<form action="login.lti" method="post">
		<table>
			<tr>
				<td>E-mail id</td>
				<td>:</td>

				<td><input type="email" class="textfields" name="email"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td>:</td>

				<td><input type="password" class="textfields" name="password"></td>
			</tr>
			<tr>
				<td colspan=2></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="" style="font-size: 15px;">Forgot Password</a>

				</td>
			</tr>
			<tr>
				<td colspan=4><br></td>
			</tr>
			<tr>
				<td colspan=3 align="center"><input type="submit" class="button" value="LOGIN">
			</tr>

		</table>
	</form>
</body>
</html>