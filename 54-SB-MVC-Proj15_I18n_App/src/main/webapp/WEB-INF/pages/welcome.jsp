<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1 style="color:green;text-align:center"><sp:message code="home.title"></sp:message> </h1>

<h2 style="color:blue;text-align:center"><a href="register" ><sp:message code="home.link1"></sp:message></a></h2>

<br><br><br>

<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
<a href="?lang=gr_GR">German</a>&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
<a href="?lang=te_IN">Telugu</a>&nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
<a href="?lang=en_US">English</a>

<br><br>
<h1 style="color:green;text-align:left">Current Active Local :: ${pageContext.response.locale}</h1>
<br><br><br>

<fmt:setLocale value = "${PageContext.response.locale}" />
<jsp:useBean id="dt" class="java.util.Date"/>

<fmt:formatDate var="fdt" value="${dt}" type="date"  dateStyle="LONG"/> <!-- LONG/SHORT -->

<h3 style="color:red; align=left">
Formatted Date :: ${fdt} 
</h3>

<fmt:formatDate var="ftime" value="${dt}" type="time"  dateStyle="LONG"/> <!-- LONG/SHORT -->

<h3 style="color:red;text-align:left">
Formatted Time :: ${ftime} 
</h3>

<fmt:formatNumber var="fCurrency" value="5000000" type="currency" ></fmt:formatNumber>

<br><br>
<h3 style="color:green;text-align:left">
Formatted Number with Currency Symbol :: ${fCurrency} 
</h3>
<fmt:formatNumber var="fNumber" value="5000000" type="number" ></fmt:formatNumber>

<br><br>
<h3 style="color:green;text-align:left">
Formatted Number :: ${fNumber} 
</h3>

<fmt:formatNumber var="fPercent" value="0.50" type="percent" ></fmt:formatNumber>

<h3 style="color:green;text-align:left">
Formatted Percent :: ${fPercent} 
</h3>