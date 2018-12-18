<%@include file="../common/IncludeTop.jsp"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table align="left" bgcolor="#008800" border="0" cellspacing="2" cellpadding="2">
<tr><td bgcolor="#FFFF88">
<a href="index.do"><b><font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a>
</td></tr>
</table>

<p>

<table width="60%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFF88">
<tr bgcolor="#FFFF88"><td align="center" colspan="2">
  <font size="4"><b>Order ${order.orderid}</b></font>
  <br /><font size="3"><b>${order.orderdate}</b></font>
</td></tr>
<font color="GREEN" size="4"><b>账单信息</b></font>

<tr bgcolor="#FFFF88"><td>
First name:</td><td>${order.billtofirstname}
</td></tr>
<tr bgcolor="#FFFF88"><td>
Last name:</td><td>${order.billtolastname}
</td></tr>
<tr bgcolor="#FFFF88"><td>
Address 1:</td><td>${order.billaddr1} 
</td></tr>
<tr bgcolor="#FFFF88"><td>
Address 2:</td><td>${order.billaddr2} 
</td></tr>
<tr bgcolor="#FFFF88"><td>
City: </td><td>${order.billcity}
</td></tr>
<tr bgcolor="#FFFF88"><td>
State:</td><td>${order.billstate}
</td></tr>
<tr bgcolor="#FFFF88"><td>
Zip:</td><td>${order.billzip}
</td></tr>
<tr bgcolor="#FFFF88"><td>
Country: </td><td>${order.billcountry}
</td></tr>



<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
你会后悔的。。。
</p>


