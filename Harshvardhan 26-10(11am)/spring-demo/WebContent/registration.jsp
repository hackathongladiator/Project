<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script> 
	function validation(form) { 
		password1 = form.password.value; 
        password2 = form.password1.value; 
		if (password1 != password2) 
		{ 
             alert ("\nPassword did not match: Please try again...") 
             return false; 
         } 
 	   else
 	   {               
             return true
        } 
            } 
	function Captcha(){
		var alpha = new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
             		var i;
             		document.getElementById("myBtn").disabled = true;
             		for (i=0;i<6;i++){
               			var a = alpha[Math.floor(Math.random() * alpha.length)];
               			var b = alpha[Math.floor(Math.random() * alpha.length)];
               			var c = alpha[Math.floor(Math.random() * alpha.length)];
               			var d = alpha[Math.floor(Math.random() * alpha.length)];
             			var e = alpha[Math.floor(Math.random() * alpha.length)];
           				var f = alpha[Math.floor(Math.random() * alpha.length)];
               			var g = alpha[Math.floor(Math.random() * alpha.length)];
              			}
            		var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
            		document.getElementById("mainCaptcha").value = code
          		}
          	function ValidCaptcha(){
              		var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
              		var string2 = removeSpaces(document.getElementById('txtInput').value);
              		if (string1 == string2){
              				document.getElementById("myBtn").disabled = false;
						}
              		else{        
              			document.getElementById("myBtn").disabled = true;
              		}
          	}
          	function removeSpaces(string){
            	return string.split(' ').join('');
          	}
</script> 

<link rel="stylesheet" type="text/css" href="Gladiator.css">
</head>
<body onload="Captcha();">
<div class="abc">
<img src="logo4.jpg">
  <a href="index.jsp">Home</a>
  <a href="about.jsp">About Us </a>
  <a href="contact.jsp">Contact Us</a>
</div>
		<form action="registration.lti" method="get" class="container" onSubmit = "return validation(this)">

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
		
		
		<strong>Captcha</strong><br><input type="text" id="mainCaptcha" class="textfields1" readonly="readonly" onchange='ValidCaptcha();' />
                <input type="button" id="refresh" value="Refresh" onclick="Captcha();" class="button1"/>
            	<input type="text" id="txtInput" class="textfields" placeholder="Enter captcha" autocomplete="off" onchange='ValidCaptcha();'/> 
		
		<input type ="submit" value="submit" id="myBtn" disabled> 
		</form>
	</body>
</html>
		