<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<h1 style="color:green;text-align:center;">Welcome to SpringBoot MVC Application</h1>
<br><br>
<a href="report">show report(GET)</a>
<br><br>
<form action="report" method="POST">
 <input type="submit" value="send(POST)">
</form>
</body>
</html>