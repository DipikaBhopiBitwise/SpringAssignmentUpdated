<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<c:forEach var="j" items="${CartList}"> 
<table>
        <tr>
		<th>Product Name</th>
		<td>${j.productname}</td></tr>
		<tr>
		<th>Product Size</th>
		<td>${j.productsize}</td>
		<th>Product Color</th>
		<td>${j.productcolor}</td>
		<th>Product Quantity</th>
		<td>${j.productquantity }</td>
		<th>Product Price</th>
		<td>${j.productprice}</td>
		
      </tr></table><br>      
</c:forEach>
<h1>Total Price:${Cartprice}</h1>

<form method="POST" action="/SpringAssignment1/spring/CartListEmpty"> 
<input type="submit" value="Add more Products"/> 
</form>
<form method="POST" action="/SpringAssignment1/spring/Logout" >
<input type="submit" value="Logout"/> 
</form>
</body>
</html>