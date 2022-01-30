<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style type = "text/css">
body,html{
height: 100%;}
</style>
</head>
<body>
<div id="header" style = "background-color: blue;height: 20%;">
<%@include file="header.html" %>
</div>
<div id="content" style = "background-color: gray;height: 70%; text-align: center;">
<br/>
<form method="post" action="greetings.jsp">
Enter Your Name<input type="text" name="name"/>
<input type="submit" value= "Enter" name="enter"/>
</form>
</div>
<div
	style="height: 8%; bottom: 0; position: relative;"><%@include file="footer.html" %></div>
</body>
</html>