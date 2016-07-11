<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<tiles:insertDefinition name="defaultTemplate"/>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<head><title>Welcome user</title></head>
<body>
<h3>Welcome, user</h3>
<hr/>
${pageContext.request.userPrincipal.name} <br/>
<a href='<c:url value="/j_spring_security_logout" />' > Logout</a>
<hr/>
Links for user...<br/>

<form name = "eee" method="POST" action="/goshowauto">
 <input type="submit" class="bu bu1" name="ee" value="ShowAuto"/>
</form>
</body></html>