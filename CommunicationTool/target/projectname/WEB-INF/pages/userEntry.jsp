<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User EWntry</title>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
<form action="landingPage">
    <input type="submit" value="return to landing page">
</form>
<form:form method="POST" commandName="user">
<form:errors path="*" cssClass="errorblock" element="div"/>
<table>
	<tr>
	<td><form:input path="userId"/></td><td><form:errors path="userId" cssClass="error"/></td>
	<td><form:input path="password"/></td><td><form:errors path="password" cssClass="error"/></td>
	<td><form:input path="userRole"/></td><td><form:errors path="userRole" cssClass="error"/></td></tr>
	<td colspan="3"><input type="submit" /></td>

</table>
</form:form>


${user.getUserId()}


</body>
</html>