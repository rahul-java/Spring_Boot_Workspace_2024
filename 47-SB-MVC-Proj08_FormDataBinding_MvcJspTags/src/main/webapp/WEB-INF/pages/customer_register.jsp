<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer_Register</title>
</head>
<body>

<h1 style="color:green;text-align:center">Customer Registration Form</h1>

<frm:form action="register" method="POST" modelAttribute="cust">
<table align="center" bgcolor="cyan">
  <tr>
    <td> Customer Id:</td>
    <td> <frm:input type="text" path="cno" /></td>
  </tr>
  <tr>
    <td> Customer Name:</td>
    <td> <frm:input type="text" path="cname" /></td>
  </tr>
  <tr>
    <td> Customer Address:</td>
    <td> <frm:input type="text" path="cadd" /></td>
  </tr>
  <tr>
    <td> Customer BillAmt:</td>
    <td> <frm:input type="text" path="billAmt" /></td>
  </tr>
  
  <tr >
    <td> <input type="submit" value="Register"/></td>
    <td> <input type="reset" value="Reset"/></td>
  </tr>
</table>
</frm:form>
<h4><a href="./">GoToHome</a></h4>

</body>
</html>