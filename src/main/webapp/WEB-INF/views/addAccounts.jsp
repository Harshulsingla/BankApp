<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Account</title>
</head>
<body>
	<form:form action="addaccounts" method="post"
		modelAttribute="accountDto">
	
	Enter customer name:<form:input path="name" />
		<br />
	Enter initial amount:<form:input path="balance" />
		<br />
	Enter customer phoneNo :<form:input path="phoneNumber" />
		<br />
	Enter customer address:<form:input path="address" />
		<br />
	Enter customer email:<form:input path="email" />
		<br />
		<input type="submit" />
	</form:form>
	
</body>
</html>