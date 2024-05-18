<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- for EL:ExpressionLanguage -->
<%@ page isELIgnored="false" import="java.util.*"%>   

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 

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

<%-- Friends : ${friends} <br>
Writing Java Code Using tags <br>
Friends(pageContext.findAttribute("friends")) : <%=Arrays.toString((String[])pageContext.findAttribute("friends")) %> <br>
Friends(request.getAttribute("friends")) : <%=Arrays.toString((String[])request.getAttribute("friends")) %> <br>
Nick-Names :${nickNames} <br>
Id-Details : ${idDetails} <br>
Phone-Number :${phoneNumbers} <br>
</b> --%>


<%-- <b>Friends ::: </b><br>
<c:forEach var="fr" items="${friends} ">
  ${fr} <br>
</c:forEach>
<hr>
<b> Nick Names :::</b><br>
<c:forEach var="nn" items="${nickNames} ">
  ${nn } <br>
</c:forEach>
<hr>
<b> Phone-Number :::</b><br>
<c:forEach var="ph" items="${phoneNumbers} ">
  ${ph } <br>
</c:forEach>
<hr>
<b> Id-Details :::</b><br>
<c:forEach var="id" items="${idDetails} ">
  ${id } <br>
</c:forEach>
<hr> --%>

<%-- <h1> Reading Model class Object Data ::: </h1>

<b>Model Attributes are :  </b> ${touristInfo } <br>
<br><br>
<c:if test="${!empty touristInfo}">
<b>Model Attributes with their field name :  </b> ${touristInfo.tid } , ${touristInfo.tname } , ${touristInfo.mobileNo }
</c:if> --%>

<h1> Reading Collection of Model class Object Data ::: </h1>

<c:forEach var="tourist" items="${touristListInfo}">
  <b>${tourist}</b><br>
</c:forEach>
<hr>
<br>
<c:choose>
 <c:when test="${!empty touristListInfo }">
   <table bgcolor="skyblue" border="1">
   <tr><th>ID</th><th>NAME</th><th>MOBILE</th><th>DESTINATION</th><th>SOURCE</th><th>Budget</th></tr>
   <c:forEach var="tourist" items="${touristListInfo}">
  <tr>
    <td>${tourist.tid}</td>
    <td>${tourist.tname}</td>
    <td>${tourist.mobileNo}</td>
    <td>${tourist.destLocation}</td>
    <td>${tourist.fromLocation}</td>
    <td>${tourist.budget}</td>
  </tr>
</c:forEach>
   </table>
 </c:when>
 <c:otherwise>
  <h1 style="color:red">No Records Found...</h1>
 </c:otherwise>
</c:choose>

</body>
</html>