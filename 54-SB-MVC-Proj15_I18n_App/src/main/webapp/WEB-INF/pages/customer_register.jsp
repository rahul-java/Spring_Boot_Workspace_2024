<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:blue;text-align:center"><sp:message code="registration.title"></sp:message> </h1>

<frm:form modelAttribute="cust" >
  <table align="center">
    <tr>
      <td><sp:message code="registration.cno"> </sp:message> </td>
      <td> <frm:input path="cno" /></td>
    </tr>
    <tr>
      <td><sp:message code="registration.name"> </sp:message> </td>
      <td> <frm:input path="name" /></td>
    </tr>
    <tr>
      <td><sp:message code="registration.address"> </sp:message> </td>
      <td> <frm:input path="address" /></td>
    </tr>
    <tr>
      <td > <input type="submit" value="<sp:message code="registration.submit" />" /></td>
    </tr>
  </table>
</frm:form>

<br><br><br>

<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
<a href="?lang=gr_GR">German</a>&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
<a href="?lang=te_IN">Telugu</a>&nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
<a href="?lang=en_US">English</a>