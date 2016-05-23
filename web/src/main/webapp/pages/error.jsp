<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<head><title>Error Page</title></head>
<body>
 Request from ${pageContext.errorData.requestURI} is failed
 <br/>
 Servlet name or type: ${pageContext.errorData.servletName}
 <br/>
 Status code: ${pageContext.errorData.statusCode}
 <br/>
 Exception: ${pageContext.errorData.throwable}
</body></html>