<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<head><title>Welcome user</title></head>
<body>
<h3>Welcome, user</h3>
<hr/>
 ${user}, hello!
<hr/>
Links for user...<br/>
Debug info - session = ${sessionScope}
<a href='<c:url value="/j_spring_security_logout" />' > Logout</a>
<form name = "eee" method="POST" action="/goshowauto">
 <input type="submit" class="bu bu1" name="ee" value="ShowAuto"/>
</form>
</body></html>