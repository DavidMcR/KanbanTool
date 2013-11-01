<!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>body
{
	background-color:#C2C2A3
}
h1{
text-align:center;
color:#A3A375;
}
h3{
text-align:center;
color:2C2C16;
}

form    {
background: -webkit-gradient(linear, bottom, left 175px, from(#CCCCCC), to(#EEEEEE));
background: -moz-linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);
margin:auto;
position:relative;
width:400px;
height:185px;
font-family: Tahoma, Geneva, sans-serif;
font-size: 14px;
font-style: italic;
line-height: 24px;
font-weight: bold;
color: #09C;
text-decoration: none;
-webkit-border-radius: 10px;
-moz-border-radius: 10px;
border-radius: 10px;
padding:10px;
border: 1px solid #999;
border: inset 1px solid #333;
-webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
-moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
}

textarea#update {
width:375px;
height:150px;
}<!--The above was amended from the website http://www.sitepoint.com/style-web-forms-css/-->
</style>

</head>
<body>
<h2>${nameOfBlog}</h2>

<a href="http://localhost:8080/projectname/displayoptions">Back to the choice page</a>
<p>${blogName }
<form:form method="POST" commandName="item">
	<table>
	<tr><td>Title: <form:input path="title" maxlength="100" size="45"/></td></tr>
	<tr><td colspan = ""><form:textarea rows="8" cols="40" path="content"/></td></tr>	
	<form:hidden path="itemName" value="${blogName }"  />
	<tr><input type="submit" /></tr>
	</table>
</form:form>

<c:set var="listTotal" value="${fn:length(listItem)}" />
<table border=1>
<c:forEach items="${listItem}" var="blogEntry" varStatus="rowNum">   

<!-- The blog posts have been inverted so the latest is at the top. However this means
the rowNum.count that counts the row number will be starting at 1 for the lowest numbered
blog post, so the calculation listTotal-"rowNum.count +1" inverts the 
row count so it matches the sequence in the SQL tbale that will be based on the 'aKey' value. -->
<c:set var="blogPostNumber" value="${listTotal-rowNum.count +1}"/>      

<tr><td width=20%></td><td><a href="http://localhost:8080/projectname/blog/blogpost/${blogEntry.aKey}"><c:out value="${blogEntry.title }" escapeXml="false"/></a></td></tr>
<tr><td width=20%>  <table><tr><td><c:out value="${blogEntry.userId}" escapeXml="false"/></td></tr>
<tr><td><c:out value="${blogEntry.insertDate}" escapeXml="false"/></td></tr></table>
<td><h3><c:out value="${blogEntry.content}" escapeXml="false"/></h3></td>

</tr>

</c:forEach> 
</table>



</body>
</html>