<%@include file="../common/IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>


<table border="0" width="100%" cellspacing="0" cellpadding="0">
<tr><td valign="top" width="20%" align="left">
<table align="left" bgcolor="#008800" border="0" cellspacing="2" cellpadding="2">
<tr><td bgcolor="#FFFF88">
<a href="index.do">
<b><font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a>
</td></tr>
</table>
</td><td valign="top" align="center">
<h2 align="center">Shopping Cart</h2>
<form method="post" action="${pageContext.request.contextPath}/item.do?path=updateCartQuantities">

<table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="5">
  <tr bgcolor="#cccccc">
  <td><b>Item ID</b></td>  <td><b>Product ID</b></td>  <td><b>Description</b></td> <td><b>是否有货?</b></td> <td><b>Quantity</b></td>  <td><b>List Price</b></td> <td><b>Total Cost</b></td>  <td>&nbsp;</td>
  </tr>
<c:if test="${cart.numberOfItems==0}">

<tr bgcolor="#FFFF88"><td colspan="8"><b>Your cart is empty.</b></td></tr>
</c:if>
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
  <td align="center">${cartitem.inStock}</td>
  <td align="center">
  <input type="text" size="3" name="quantity${cartitem.item.itemid}" value="${cartitem.quantity}" /> 
  <td align="right">${cartitem.item.listprice}</td>
  <td align="right">${cartitem.total}</td>
  <td><a href="${pageContext.request.contextPath}/item.do?path=removeItemFromCart&workingItemId=${cartitem.item.itemid}">
  <img border="0" src="${pageContext.request.contextPath}/images/button_remove.gif" /></a></td>
  </tr>
</c:forEach>
<tr bgcolor="#FFFF88">
<td colspan="7" align="right">
<b>Sub Total: ${cart.subTotal} </b><br />
<input type="image" border="0" src="${pageContext.request.contextPath}/images/button_update_cart.gif" name="update" /></td>
<td>&nbsp;</td>
</tr>
</table>
<center>

  
    <font color="green"><B>&lt;&lt; Prev</B></font>
 

<font color="green"><B>Next &gt;&gt;</B></font>
</center>
</form>


<br /><center><a href="${pageContext.request.contextPath}/item.do?path=checkout"><img border="0" src="${pageContext.request.contextPath}/images/button_checkout.gif" /></a></center>


</td>


<td valign="top" width="20%" align="right"><!--  <include file="IncludeMyList.jsp" %>--></td>
</tr>
</table>

<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
继续的话就可以下单了！
</p>


 