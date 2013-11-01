<html><!-- Spring MVC form taken from http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ -->
<head>
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
color: #144196;
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

<form  action="login" method="post">
user name: <input type="text" name="userId"/><p/>
password: <input type="password" name="password"/>
<input type="submit" value="login"/></form>
</body>
</html>