<!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ --><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Entry</title>
<style>

</style>
</head>
<body>
<a href="http://localhost:8080/projectname/displayoptions">Back to the choice page</a>
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


<p>this is the ${user.getUserId()}
<table border=1>
<tr><h3></h3><td>User Id</td><td>Password</td><td>User Role</td></h3></tr>
<c:forEach items="${userList }" var="userList">
<tr>
<td> <c:out value="${userList.userId}" escapeXml="false"/></td>
<td><c:out value="${userList.password}" escapeXml="false"/></td>
<td><c:out value="${userList.userRole}" escapeXml="false"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>

</body>
</html>