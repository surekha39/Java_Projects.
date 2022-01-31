<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %> 
  <%@ page import="com.flywheel.beans.Flight" %> 
   <%@ page import="com.flywheel.controllers.SearchFlightsServlet" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Please pay the bill</h1>
<% 
       HttpSession session2 = request.getSession();
       String airline = (String) session2.getAttribute("airline");
       String air = airline.substring(0, airline.indexOf("and"));
       String price = airline.substring((airline.indexOf("and")+3));
%>
<h4> <%  out.println("Please Pay Rupees " + price +" for " + air +"Flight"); %></h4>
<Form  action = "success.jsp" method = "post">
Card Number : <input type = "text" name = " cardnum">
<br>
<br>
Expiry Date : <input type = "text" name = " exp">
      CVV : <input type = "text" name = " cardnum">
      <br> <br>
      
Name on card : <input type = "text" name = " name">
<br><br>
<input type="submit" value = " Pay">
</Form>
</div>
</body>
</html>