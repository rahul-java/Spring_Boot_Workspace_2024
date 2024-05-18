<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer_Register</title>
</head>
<body>

<h1 style="color:green;text-align:center">Customer Registration Form</h1>

<form action="register" method="POST">
<table align="center" bgcolor="cyan">
  <tr>
    <td> Customer Id:</td>
    <td> <input type="text" name="cno" /></td>
  </tr>
  <tr>
    <td> Customer Name:</td>
    <td> <input type="text" name="cname" /></td>
  </tr>
  <tr>
    <td> Customer Address:</td>
    <td> <input type="text" name="cadd" /></td>
  </tr>
  <tr>
    <td> Customer BillAmt:</td>
    <td> <input type="text" name="billAmt" /></td>
  </tr>
  
  <tr >
    <td> <input type="submit" value="Register"/></td>
    <td> <input type="reset" value="Reset"/></td>
  </tr>
</table>
</form>
<h4><a href="./">GoToHome</a></h4>

</body>
</html>