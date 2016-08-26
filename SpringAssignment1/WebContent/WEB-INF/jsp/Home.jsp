<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<!-- <h1>Logged in successfully</h1> -->
	
<%-- <h6><%=request.getParameter("notselected") %></h6> --%>

	<form:form method="POST" commandName="product" action="/SpringAssignment1/spring/Selected" >
	${notselected}
		<c:forEach var="i" items="${ItemList}">
			<%-- <input type="checkbox" id="productcheckbox" value="${i.productname}"/>${i.productname} --%>

			<form:checkbox path="productName"  value="${i.productname}" />${i.productname}

</c:forEach>
		<input type="submit" value="Submit" />
	</form:form>
<form:form  method="POST" action="/SpringAssignment1/spring/Logout" >
<input type="submit" value="Logout"/> </form:form>
</body>
</html>