<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List" %> 
  <%@ page import="com.flywheel.beans.Flight" %> 
   <%@ page import="com.flywheel.controllers.SearchFlightsServlet" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flywheel</title>
</head>
<body>
<div align="center">
 <h2> Please select your Choice </h2>
 <br>
 
  <h3>Please select an option</h3>
  <form action= "register.jsp" method ="post">
 <table border="1" style="width: 70%">
 <tr>
 <th>Select </th>
 <th> <h3>Airline</h3> </th>
 <th><h3>Price</h3></th>
 </tr>
 <%
         List<Flight> myFlight = (List<Flight>) request.getAttribute("flights");
        HttpSession session2 = request.getSession();
        session2.setAttribute("flights", myFlight);
         for(Flight flight :myFlight){ 
 %>
      <tr>
     <td style="text-align : center"><input type="radio" name="airline" value="<%= flight.getFlightname() %> and <%= flight.getPrice()%>">
    <td style="text-align : center"><h2> <%= flight.getFlightname()%></h2></td>
     <td style="text-align : center"> <h2><%=flight.getPrice()%></h2></td>
   </tr> 
   </table>
 <%} %>
 <input type = "submit" value =" Submit">
</form>
 </div>
</body>
</html>