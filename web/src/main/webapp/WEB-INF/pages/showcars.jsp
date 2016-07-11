<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<tiles:insertDefinition name="defaultTemplate"/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Доступные автомобили</title>
</head>
<body>
<table border="1">
    <tr bgcolor="#CCCCCC">
        <td align="center"><strong>Модель</strong></td>
        <td align="center"><strong>Год</strong></td>
        <td align="center"><strong>Цвет</strong></td>
    </tr>
    <c:forEach var="car" items="${carsList}">
        <tr>
            <td><c:out value="${ car.model }"/></td>
            <td><c:out value="${ car.year }"/></td>
            <td><c:out value="${ car.color }"/></td>
        </tr>

    </c:forEach>


</table>
<table>
    <tr>
        <form:form method="GET" action="/1">
            <a href="controller?command=p1">1</a>
        </form:form>
        <form:form method="GET" action="/2">
            <a href="2">2</a>
        </form:form>
        <form:form method="GET" action="/3">
            <a href="/3">3</a>
        </form:form>
        <form:form method="GET" action="/4">
            <a href="/4">4</a>
        </form:form>
    </tr>
</table>
<form name="eee" method="POST" action="/gobackuser">
    <input type="submit" class="bu bu1" name="ee" value="GoBack"/>
</form>
</body>
</html>