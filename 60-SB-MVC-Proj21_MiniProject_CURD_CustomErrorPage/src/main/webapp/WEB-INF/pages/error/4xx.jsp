<%@ page language="java" isErrorPage="true" isELIgnored="false"  %>

<h1 style="color:red;text-align:center">4xx Error Page :: Client Side Error (4xx.jsp)</h1>

<hr>

Error is :: ${exception.getMessages()}

<br><br>

Other Deetails ::: <br>
  status :: ${status}<br>
  path :: ${path}<br>
  message :: ${message}