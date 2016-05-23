<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
	<head>
		<title>Регистрация</title>
	</head>
	<body>
		<form name="addCarsForm" method="POST" action="controller">

			ДОБАВИТЬ АВТО<br/>
			Введите данные авто:<br/>
			<table>
				<tr>
					<td>Модель:</td>
					<td><input type="text" name="model" value="" size="20"/></td>
				</tr>
				<tr>
					<td>Год:</td>
					<td><input type="text" name="year" value="" size="20" /></td>
				</tr>
				
				<tr>
					<td>Цвет:</td>
					<td><input type="text" name="color" value="" size="20"/></td>
				</tr>
				
				<tr>
					<td><input type="submit" name="command" value="addproduct" /></td>
				</tr>
				
				</table>
			УДАЛИТЬ АВТО
			<table>
				<tr>
					<td>Айди:</td>
					<td><input type="text" name="id" value="" size="20"/></td>
				</tr>

				<tr>
					<td><input type="submit" name="command" value="deleteproduct" /></td>
					<td><a href="controller?command=backadmin">Вернуться обратно</a></td>
				</tr>

			</table>

				${success}	
				${operationMessage} 
			${errorUserExsists}
				</form>
		
		
	</body>
</html>