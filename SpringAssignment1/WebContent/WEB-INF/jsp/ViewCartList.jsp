<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>

<body>
<center>${msg}</center>
<c:forEach var="j" items="${CustomerListm}"> 
<form method="POST" action="/SpringAssignment1/spring/Remove"> 
<%-- <form:checkbox path="productName" id="" value="${i.productname}" /> --%>
<input type="hidden" value="${j.productname}" name="productremove"/>
<table>
      <tr>
		<th>Product Name</th>
		<td>${j.productname}</td>
		<th>Product Size</th>
		<td>${j.productsize}</td>
		<th>Product Color</th>
		<td>${j.productcolor}</td>
		<th>Product Quantity</th>
		<td>${j.productquantity }</td>
		<th>Product Price</th>
		<td>${j.productprice}</td>
		
      </tr></table><br>
 
<input type="submit"  value="Remove from Cart">
</form>
</c:forEach>
<!-- <a href="/SpringAssignment1/spring/Home">Add more Products</a> -->
<form  method="POST" action="/SpringAssignment1/spring/AddMore"> 
<input type="submit" value="Add more Products"/> <br>
</form>
<form method="POST" action="/SpringAssignment1/spring/PlaceOrder" >
<input type="submit" value="PlaceOrder"/> 
</form><br>
<form  method="POST" action="/SpringAssignment1/spring/Logout" >
<input type="submit" value="Logout"/> 
</form><br>
</body>
</html>