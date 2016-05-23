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
<a href="controller?command=logout">Logout</a>
<a href="controller?command=gocars">Список авто</a>
</body></html>