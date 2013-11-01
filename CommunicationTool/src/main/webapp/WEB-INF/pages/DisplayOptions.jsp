<!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ --><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Choose a page to visit:</h2>

<h2>Blog</h2>
<table border="3">

<c:forEach items="${blogList}" var="blogName">

<tr><td>
<a href="<c:out value="http://localhost:8080/projectname/blog/${blogName}" escapeXml="false"/>">${blogName}</a>
</td>

<td>
blog
</td>

</tr>
</c:forEach>

</table>
<h2>Forum</h2>
<table border="3">
<c:forEach items="${forumList }" var="forumName">
<tr><td>
<a href="<c:out value="http://localhost:8080/projectname/forum/${forumName}" escapeXml="false"/>">${forumName}</a>
</td>

<td>
forum
</td>

</tr>
</c:forEach>

</table>

<a href=" http://localhost:8080/projectname/contacts">Add a new user </a>

<a href="http://localhost:8080/projectname/newblog">Create new blogs or users</a>

</body>
</html>