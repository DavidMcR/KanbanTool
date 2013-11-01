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
}
<!--The above was amended from the website http://www.sitepoint.com/style-web-forms-css/-->
</style>
</head>
<body>
<a href="http://localhost:8080/projectname/blog/${item.itemName}">Back to blog</a>

<h2>${item.itemName}</h2>
<c:set var="itempath" value="comment1"/>
<c:set var="index" value="${listItem.commentIndex }"/>
<p>${testAttribute.content}

<c:if test="${index<10}">
<form:form method="POST" commandName="item">
	<table>
	<tr><td colspan = ""><form:textarea rows="8" cols="40" path="${itempath }"/></td></tr>	
	<form:hidden path="itemName" value="${item.itemName }"  />
	<form:hidden path="aKey" value="${item.aKey }"  />
	<form:hidden path="commentIndex" value="${listItem.commentIndex}"  />
	<tr><input type="submit" /></tr>
	</table>
</form:form>
</c:if>
<c:if test="${index>=10}">
Comments for this blog post are full. 
</c:if>
${index}
<c:if test="${index>=1}">
<table border ="2"> 


<c:if test="${index>11}">
<tr><td>
${listItem.comment10 }</td></tr>
</c:if>
<c:if test="${index>=9}">
<tr><td>${listItem.comment9 }</td></tr>
</c:if>
<c:if test="${index>=8}">
<tr><td>${listItem.comment8 }</td></tr>
</c:if>
<tr><td><c:if test="${index>=7}">
<tr><td>${listItem.comment7 }</td></tr>
</c:if>

<c:if test="${index>=6}">
<tr><td>${listItem.comment6 }</td></tr>
</c:if>
<c:if test="${index>=5}">
<tr><td>${listItem.comment5 }</td></tr>
</c:if>

<c:if test="${index>=4}">
<tr><td>${listItem.comment4 }</td></tr>
</c:if>
<c:if test="${index>=3}">
<tr><td>${listItem.comment3 }</td></tr>
</c:if>
<c:if test="${index>=2}">
<tr><td>${listItem.comment2 }</td></tr>
</c:if>
<c:if test="${index>=1}">
<tr><td>${listItem.comment1 }</td></tr>
</c:if>
</table>
</c:if>


</body>
</html>