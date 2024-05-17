<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- for EL:ExpressionLanguage -->
<%@ page isELIgnored="false" import="java.util.*"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<h1 style="color:green;text-align:center;">Welcome to SpringBoot MVC Application</h1>
<br><br>
<b>
<%-- Model Attributes are ::: ${name} ,${sysDate} --%>

Friends : ${friends} <br>
Writing Java Code Using tags <br>
Friends(pageContext.findAttribute("friends")) : <%=Arrays.toString((String[])pageContext.findAttribute("friends")) %> <br>
Friends(request.getAttribute("friends")) : <%=Arrays.toString((String[])request.getAttribute("friends")) %> <br>
Nick-Names :${nickNames} <br>
Id-Details : ${idDetails} <br>
Phone-Number :${phoneNumbers} <br>
</b>
</body>
</html>