<!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ --><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

<form:form method="POST" action="contacts">
<form:errors path="*" cssClass="errorblock" element="div"/>
<table>
	<tr>
	<td><form:label path="userId">User Id: </form:label></td><td><form:input path="userId"/></td><td><form:errors path="userId" cssClass="error"/></td>
	<td><form:label path="password">Password: </form:label><form:password path="password"/></td><td><form:errors path="password" cssClass="error"/></td>
	<td><form:select path="userRole" ><form:option value="user"/><form:option value="administrator"/></form:select></td></tr>
	<tr><td><input type="submit" value="Add User"/></td></tr>
</table>
</form:form>
${user.getUserId() }
${command}
</body>
</html>