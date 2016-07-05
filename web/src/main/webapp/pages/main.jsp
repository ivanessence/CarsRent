<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<head><title>Welcome admin</title></head>
<body>
<h3>Welcome, admin</h3>
<hr/>
 ${user}, hello!
<hr/>
Links for admin...<br/>

<form name = "ee" method="POST" action="/clients">
 <input type="submit" class="bu bu1" name="ee" value="ShowClients"/>
</form>

<form name = "e" method="POST" action="/goaddauto">
 <input type="submit" class="bu bu1" name="ee" value="AddAuto"/>
</form>

<a href='<c:url value="/j_spring_security_logout" />' > Logout</a>
Debug info - session = ${sessionScope}
</body></html>