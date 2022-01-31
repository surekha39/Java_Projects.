<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2> Admin Dashboard</h2>
<hr>
<br>
<div align ="center">
<form  action ="updateflights" method = "post">
<label for="flightname">Select Airline: </label>

<select name="flightname" id="fname">
  <option value="Air India">Air India</option>
  <option value="Vistara">Vistara</option>
  <option value="Spice Jet">Spice jet</option>
  <option value="Indigo">Indigo</option>
  <option value="GoAir">Go Air</option>
    
</select>
<br> 
<br>
<label for="source">Source:</label>

<select name="source" id="src">
  <option value="mumbai">Mumbai</option>
  <option value="bengaluru">Bengaluru</option>
  <option value="chennai">Chennai</option>
  <option value="hyderabad">Hyderabad</option>
  <option value="kochi">Kochi</option>
  <option value="delhi">Delhi</option>
  <option value="ahmedabad">Ahmedabad</option>
  <option value="kolkata">Kolkata</option>
  
</select>
<br>
<br>
<label for="destin">Destination :</label>

<select name="destination" id="destin">
  <option value="mumbai">Mumbai</option>
  <option value="bengaluru">Bengaluru</option>
  <option value="chennai">Chennai</option>
  <option value="hyderabad">Hyderabad</option>
  <option value="kochi">Kochi</option>
  <option value="delhi">Delhi</option>
  <option value="ahmedabad">Ahmedabad</option>
  <option value="kolkata">Kolkata</option>
  
</select>
Date of journey  :   <input type="date" name="date" 
        placeholder="dd-mm-yyyy" value=""
        min="1997-01-01" max="2030-12-31">
<br>
<br>
Price :<input type ="text" name="price">
<br>
<br>
Capacity   : <input type = "text" name = "passnum" >
<br>
<br>
<input type= "submit" value="Add Flight">
<br>
<br>
<input type = "reset" value ="Clear">
</form>
</div>
</body>
</html>
