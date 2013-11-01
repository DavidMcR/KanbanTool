<!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ --><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Blog</title>
</head>
<body>
<h3>This is the create blog page</</h3>
<form:form  method="POST" commandName="itemName">
	<table>
		<tr><td>Enter blog name:</td></tr>
		<tr><td><form:input path="itemName"/></td></tr>
		<tr><td><form:radiobutton path="type" value="blog"/>blog 
</td><td><form:radiobutton path="type" value="forum"/>forum</td></tr>
		<tr><td><input type="submit"  /></td></tr>
	</table>
</form:form>


</body>
</html>