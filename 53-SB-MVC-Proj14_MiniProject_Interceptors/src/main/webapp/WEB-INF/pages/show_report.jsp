<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:blue;text-align:center"> Report Page</h1>

<c:choose>
  <c:when test="${!empty pageData }">
   <table border="1" align="center" bgcolor="cyan">
   
    <tr>
      <th>EmpNo</th>
      <th>EmpName</th>
      <th>Job</th>
      <th>Salary</th>
      <th>Dept</th>
      <th>Operations</th>
    </tr>
    <c:forEach var="emp" items="${pageData.getContent() }">
    <tr>
      <td>${emp.empNo }</td>
      <td>${emp.empName }</td>
      <td>${emp.job }</td>
      <td>${emp.salary }</td>
      <td>${emp.deptNo }</td>
      <td>
       <a href="edit?id=${emp.empNo }"><img src="images/edit6.png" width="25px" height="25px"> </a>
       &nbsp;&nbsp;
       <a href="delete?id=${emp.empNo }" onclick="return confirm('ARE YOU SURE TO DELETE THIS EMPLOYEE ?')"><img src="images/delete1.png" width="25px" height="25px"> </a>
      
      </td>
    </tr>
   </c:forEach>
   </table>
   <center>
   <c:if test="${!pageData.isFirst() }">
    <a href="report?page=0">First</a>
   </c:if>
   <c:if test="${!pageData.isLast() }">
    <a href="report?page=${pageData.getNumber()+1}">Next</a>
   </c:if>
   
   <c:forEach var="i" begin="0" step="1" end="${pageData.getTotalPages()-1}" >
    <a href="report?page=${i}">[${i+1}]</a>&nbsp;&nbsp;&nbsp;&nbsp;
   </c:forEach>
   
   <c:if test="${!pageData.isLast() }">
    <a href="report?page=${pageData.getTotalPages()-1}">Last</a>
   </c:if>
   <c:if test="${!pageData.isFirst() }">
    <a href="report?page=${pageData.getNumber()-1}">Previous</a>
   </c:if>
    
   </center>
  </c:when>
  <c:otherwise>
    <h1 style="color:red;text-align:center">Records Not Found</h1>
  </c:otherwise>
</c:choose>
<center><h4 style="color:green;">${resultMsg }</h4></center>
<br>
<h1 style="color:blue;text-align:center"><a href="./">Home_Page<img src="images/home5.jpg" width="50px" height="50px"/></a></h1>
<h1 style="color:blue;text-align:center"><a href="register">Register_Here<img src="images/add1.jpg" width="50px" height="50px"/></a></h1>