<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  HttpSession session2 = request.getSession();
       String airline =  request.getParameter("airline");
     session2.setAttribute("airline", airline);
    %>
    
     <br>
     <div align ="center">
     <h3> Please Register with details</h3>
        <br>
          <form action="payment.jsp" method="post">
           Name: <input type="text" name= "name"><br>
           <br>
           Phone No: <input type="text" name="ph">
            <br>
             <br>
            Aadhar No:   <input type="text" name="ad">
             <br>
              <br>
            <input type = "submit">  
          </form>
          </div>
</body>
</html>