<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<tiles:insertDefinition name="defaultTemplate"/>
<head>
    <title>Регистрация</title>
</head>
<body>
<form name="addCarsForm" method="POST" action="/addcar">

    ДОБАВИТЬ АВТО<br/>
    Введите данные авто:<br/>
    <table align="center">
        <tr>
            <td>Модель:</td>
            <td><input type="text" name="model" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Год:</td>
            <td><input type="text" name="year" value="" size="20"/></td>
        </tr>

        <tr>
            <td>Цвет:</td>
            <td><input type="text" name="color" value="" size="20"/></td>
        </tr>

        <tr>
            <td><input type="submit" name="command" value="addproduct"/></td>
        </tr>

    </table>
</form>

<table align="center">
  <td>УДАЛИТЬ АВТО</td>
    <tr>
        <td>Айди:</td>
        <form name="ee" method="POST" action="/delete">

            <td><input type="text" name="id" value="" size="20"/></td>
            <td><input type="submit" name="command" value="deleteproduct"/></td>
            <td>${success}</td>
            <td>${operationMessage}</td>

        </form>

    </tr>
</table>
<tr>

    <form name = "eee" method="POST" action="/gobackadmin">
        <input type="submit" class="bu bu1" name="ee" value="GoBack"/>
    </form>
</tr>

</table>


${errorUserExsists}


</body>
</html>