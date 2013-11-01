<!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ --><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Blog Admin</title>
</head>
<body>
<h3>Create Blog Admin</h3>
<form:form  method="POST" commandName="blogName">
	<table>
		<tr><td>Enter item name:</td></tr>
		<tr><td><form:input path="blogName"/></td></tr>
		<tr><td>Enter table name:</td></tr>
		<tr><td><form:input path="tableName"/></td></tr>
		<tr><td><input type="submit" /></td></tr>
		
	</table>
</form:form>

</body>
</html>