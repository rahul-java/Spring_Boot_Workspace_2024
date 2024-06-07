<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<script language="JavaScript" src="js/validation.js" ></script>

<h1 style="color:green;text-align:center">Employee Registration Form</h1>

<div>
  <frm:form modelAttribute="emp" onsubmit="return validate(this)">
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
       <td><frm:input path="empName"/> 
       <frm:errors path="empName" style="color:red;"></frm:errors>
       <span id="empNameError" style="color:red;"></span>
       </td>
     </tr>
     <tr>
       <td>Employee Design :</td>
       <td><frm:input path="job"/> 
       <frm:errors path="job" style="color:red;"></frm:errors>
       <span id="jobError" style="color:red;"></span>
       </td>
     </tr>
     <tr>
       <td>Employee Salary :</td>
       <td><frm:input path="salary"/>
       <frm:errors path="salary" style="color:red;"></frm:errors>
       <span id="salaryError" style="color:red;"></span>
        </td>
     </tr>
     <tr>
       <td>Employee Dept :</td>
       <td><frm:input path="deptNo"/>
       <frm:errors path="deptNo" style="color:red;"></frm:errors>
       <span id="deptNoError" style="color:red;"></span>
        </td>
     </tr>
     
      <tr>
       <td><input type="submit" value="Register"/></td>
        <td><input type="reset" value="Cancel"/></td>
     </tr>
    
    </table>
  </frm:form>
</div>