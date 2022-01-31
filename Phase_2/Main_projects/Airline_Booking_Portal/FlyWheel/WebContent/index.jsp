<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.flywheel.util.HibernateUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Fly Wheel</title>
</head>
<body>
<div align="right">
<h2>
<a href = "admin.jsp"> Admin Log in</a>
</h2>
</div>
<div  align ="center">  
     <h2> Log in </h2>
     <h4>Please enter your name to continue</h4>
				<form action="userlogin" method = "post" >
					Enter your name : <input  type="text"  name= "username">
					<br><br>
					
					<input type="submit" value ="Log in">                               <input type ="reset" name="Clear">
				</form>
				
				 </div>
</body>
</html>