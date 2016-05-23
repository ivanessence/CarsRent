<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
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
					<td><c:out value="${ car.model }" /></td>
					<td><c:out value="${ car.year }" /></td>
					<td><c:out value="${ car.color }" /></td>
				</tr>
			</c:forEach>
		</table>
		<a href="controller?command=backuser">Вернуться обратно</a>
		<a href="controller?command=logout">Выйти из системы</a>
	</body>
</html>