<%@include file="../common/IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>


<table border="0" width="100%" cellspacing="0" cellpadding="0">
<tr><td valign="top" width="20%" align="left">
<table align="left" bgcolor="#008800" border="0" cellspacing="2" cellpadding="2">
<tr><td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/category.do?path=show">
<b><font color="BLACK" size="2">&lt;&lt; Shopping Cart</font></b></a>
</td></tr>
</table>
</td>

<td valign="top" align="center">
<h2 align="center">Checkout Summary</h2>

<table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="5">

  <tr bgcolor="#cccccc">
  <td><b>Item ID</b></td>  <td><b>Product ID</b></td>  <td><b>Description</b></td> <td><b>In Stock?</b></td> <td><b>Quantity</b></td>  <td><b>List Price</b></td> <td><b>Total Cost</b></td>
  </tr>
<c:forEach items="${cartItems}" var="cartitem">

  <tr bgcolor="#FFFF88">
  <td><b>

<a href="${pageContext.request.contextPath}/item.do?path=show&itemId=${cartitem.item.itemid}">
${cartitem.item.itemid}</a></b></td>
   <td>${cartitem.item.productid}</td>
  <td>
       ${cartitem.item.attr1}
  ${cartitem.item.attr2}
  ${cartitem.item.attr3}
  ${cartitem.item.attr4}
  ${cartitem.item.attr5}
    </td>
  <td align="center">${cartitem.inStock }</td>
  <td align="center">
  ${cartitem.quantity }
  </td>
  <td align="right"> ${cartitem.item.listprice}</td>
  <td align="right">${cartitem.total}</td>
  </tr>
</c:forEach>
<tr bgcolor="#FFFF88">
<td colspan="7" align="right">
<b>Sub Total: ${cart.subTotal}</b><br />

</td>
</tr>
</table>
<center>

  <img src="${pageContext.request.contextPath}/images/button_prev.gif" border="0">
 

<img src="${pageContext.request.contextPath}/images/button_next.gif" border="0">

</center>
<br>
<center><a href="${pageContext.request.contextPath}/orders.do?path=neworderform"><img border="0" src="${pageContext.request.contextPath}/images/button_continue.gif" /></a></center>
</td>


<td valign="top" width="20%" align="right">&nbsp;

</td>

</tr>
</table>

<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
再好好确认一下！
</p>




 