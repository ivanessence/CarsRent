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

<a href="controller?command=logout">Logout</a>
<a href="controller?command=clients">Показать список клиентов</a> <br/>
<a href="controller?command=gotoaddproduct">Добавить авто</a> <br/>
Debug info - session = ${sessionScope}
</body></html>