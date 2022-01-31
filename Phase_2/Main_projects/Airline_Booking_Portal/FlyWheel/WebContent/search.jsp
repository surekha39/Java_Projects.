<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyWheel</title>
</head>
<body>
               <div align = "center">           
		<%
					
					HttpSession session2 = request.getSession();
									if(session2.isNew())
									{
										out.println("please login again");
									}
									else
									{
										 out.print("Hai ");
		                                 out.println((String) session2.getAttribute("uname"));
									}
		%>        
       
<br>
<h3> Please fill in the details  of your trip</h3>

       <form action="searchflights" method = "post">
             Source : <input type="text" name = "source"  placeholder ="Boarding at">
             <br>
             <br>
             Destination : <input type="text" name = "destin"  placeholder ="Destined to">
             <br>
             <br>
             Date : <input type="date" name = "date"  placeholder ="On - dd/mm/yyyy">
             <br>
             <br>
             Passengers : <input type = "text" name= "passnum" placeholder = "For How many ">
             <br>
             <br>
             <input type = "submit" value ="Get Flights">                               <input type="reset" value = "Clear">
       </form>
       </div>
</body>
</html>