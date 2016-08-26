<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Selected</h1>
<center>${msg}</center>
<c:forEach var="j" items="${selected}"> 
<form method="POST" action="/SpringAssignment1/spring/Add"> 
<%-- <form:checkbox path="productName" id="" value="${i.productname}" /> --%>
<input type="hidden" value="${j.productname}" name="productadded"/>
<table>
      <tr>
		<th>Product Name</th>
		<td>${j.productname}</td></tr>
		<tr>
		<th>Product Size</th>
		<td>${j.productsize}</td>
		<th>Product Color</th>
		<td>${j.productcolor}</td>
		<th>Product Stock</th>
		<td>${j.productstock }</td>
		<th>Product Price</th>
		<td>${j.productprice}</td>
		
      </tr></table><br>
 
<input type="submit"  value="Add to Cart">
</form><br>
</c:forEach>
<form method="POST" action="/SpringAssignment1/spring/AddMore"> 
<input type="submit" value="View Products"/> <br>
</form>
<form method="POST" action="/SpringAssignment1/spring/View"> 
<input type="submit" value="View Cart"/> <br>
</form>
<form  method="POST" action="/SpringAssignment1/spring/Logout" >
<input type="submit" value="Logout"/> <br>
</form>



</body>
</html>