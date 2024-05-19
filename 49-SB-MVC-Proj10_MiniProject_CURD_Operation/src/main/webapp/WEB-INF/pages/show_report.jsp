<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:blue;text-align:center"> Report Page</h1>

<c:choose>
  <c:when test="${!empty empList }">
   <table border="1" align="center" bgcolor="cyan">
   
    <tr>
      <th>EmpNo</th>
      <th>EmpName</th>
      <th>Job</th>
      <th>Salary</th>
      <th>Dept</th>
    </tr>
    <c:forEach var="emp" items="${empList }">
    <tr>
      <td>${emp.empNo }</td>
      <td>${emp.empempName }</td>
      <td>${emp.job }</td>
      <td>${emp.salary }</td>
      <td>${emp.deptNo }</td>
    </tr>
   </c:forEach>
   </table>
  </c:when>
  <c:otherwise>
    <h1 style="color:red;text-align:center">Records Not Found</h1>
  </c:otherwise>
</c:choose>
<br><br>
<h1 style="color:blue;text-align:center"><a href="./"><img src="images/home5.jpg" width="50px" height="50px"/></a></h1>