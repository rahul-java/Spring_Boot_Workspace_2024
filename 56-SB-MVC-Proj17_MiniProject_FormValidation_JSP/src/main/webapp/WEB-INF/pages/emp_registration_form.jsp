<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:green;text-align:center">Employee Registration Form</h1>

<div>
  <frm:form modelAttribute="emp">
  <p style="text-align:center;color:red;">
   <frm:errors path="*" />
  </p>
  
    <table align="center" bgcolor="cyan">
     <%-- <tr>
       <td>Employee No :</td>
       <td><frm:input path="empNo"/> </td>
     </tr> --%>
     <tr>
       <td>Employee Name :</td>
       <td><frm:input path="empName"/> </td>
     </tr>
     <tr>
       <td>Employee Design :</td>
       <td><frm:input path="job"/> </td>
     </tr>
     <tr>
       <td>Employee Salary :</td>
       <td><frm:input path="salary"/> </td>
     </tr>
     <tr>
       <td>Employee Dept :</td>
       <td><frm:input path="deptNo"/> </td>
     </tr>
     
      <tr>
       <td><input type="submit" value="Register"/></td>
        <td><input type="reset" value="Cancel"/></td>
     </tr>
    
    </table>
  </frm:form>
</div>