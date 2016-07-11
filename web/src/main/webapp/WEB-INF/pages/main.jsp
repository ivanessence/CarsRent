<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<tiles:insertDefinition name="defaultTemplate"/>
<head><title>Welcome admin</title></head>
<body>
<h3>Welcome, admin</h3>
<hr/>
${pageContext.request.userPrincipal.name} <br/>
<a href='<c:url value="/j_spring_security_logout" />'> Logout</a>
<hr/>

<form name="ee" method="POST" action="/clients">
    <input type="submit" class="bu bu1" name="ee" value="ShowClients"/>
</form>

<form name="e" method="POST" action="/goaddauto">
    <input type="submit" class="bu bu1" name="ee" value="AddAuto"/>
</form>

</body>
</html>