<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
 <title>CarRent</title>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
 <spring:url value="/css/style.css" var="mainCss" />
 <!-- Bootstrap -->
 <link rel="stylesheet" href="css/style.css">


</head>

<body>

<form:form name = "loginPage" method="GET" action="/login">


 <spring:message code="page.common.input.login"/><br/>

<input type="text" name="login" value=""/>
<br/><spring:message code="page.common.input.password"/><br/>
<input type="password" name="password" value=""/>
 <br/>
${errorLoginPassMessage}
 <br/>
${wrongAction}
 <br/>

<input type="submit" class="bu bu1" name="log" value="LogIn"/>
</form:form>

<form name = "reg" method="POST" action="/registration">
<input type="submit" class="bu bu1" name="reg" value="SignUp"/>
</form>

<div class="table">
<table>
 <tr>
<td> Language : <a href="?locale=ru">English</a>|
 <a href="?locale=en">Chinese</a>
</td>

  Current Locale : ${pageContext.response.locale}</table>
 </tr>
</div>



<%--Links for guest...<br/>--%>
<%--Debug info - session = ${sessionScope}--%>
</body></html>

<h2 class="two">CAR RENT</h2>

<div class="foot">
 <h1>©2016 by Ivan Bolotin</h1>

</div>


</body>

