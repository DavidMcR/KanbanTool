<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</style>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Title goes here</h1>

<form method="POST" action="hello">
<input type="submit"  > 
<span>blog entry</span>
<input type="text" name="title"/>
<textarea id= "update" name="blogUpdate"></textarea>

</form>

<table border=1>
<c:forEach items="${blogList }" var="blogEntry">
<tr><td width=20%>  <table><tr><td><c:out value="${blogEntry.userId}" escapeXml="false"/></td></tr>
<tr><td><c:out value="${blogEntry.insertDate}" escapeXml="false"/></td></tr></table>
<td><h3><c:out value="${blogEntry.thingString}" escapeXml="false"/></h3></td>
</tr>
</c:forEach>
</table>
<table>
</body>
</html>