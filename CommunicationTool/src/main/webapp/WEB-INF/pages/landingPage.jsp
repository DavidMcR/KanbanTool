<!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ --><!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ --><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1> ${user.getUserId()} is a boss fella</h1>

<table>
<tr><th>value</th><th>square</th></tr>
<c:forEach var="x" begin="0" end="10" step="2">
<tr><td><c:out value="${x}"/></td>
<td><c:out value="${x*x}"/></td></tr>
</c:forEach>
</table>
<form  action="blog" method="get">
user name: <input type="text" name="userId"/><p/>
password: <input type="password" name="password"/>
<input type="submit" value="login"/></form>

</body>
</body>
</html>