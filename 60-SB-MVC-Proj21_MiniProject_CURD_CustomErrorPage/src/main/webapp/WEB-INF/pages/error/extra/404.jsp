<%@ page language="java" isErrorPage="true" isELIgnored="false"  %>

<h1 style="color:red;text-align:center">404 Error Page :: Requested Resource Not Found (404.jsp)</h1>

<hr>

Error is :: ${exception.getMessages()}

<br><br>

Other Deetails ::: <br>
  status :: ${status}<br>
  path :: ${path}<br>
  message :: ${message}