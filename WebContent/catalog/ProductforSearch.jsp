<%@include file="../common/IncludeTop.jsp"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table  bgcolor="#008800" border="0" cellspacing="2" cellpadding="2">
<tr><td bgcolor="#FFFF88">
<a href="index.do">   <b><font color="BLACK" size="2">&lt;&lt;返回商店 </font></b></a>
</td>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=year&year=2010">   <b><font color="BLACK" size="2">&lt;&lt;2010 </font></b></a>
</td>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchyear&year=2011">   <b><font color="BLACK" size="2">&lt;&lt;2011</font></b></a>
</td>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchyear&year=2012">   <b><font color="BLACK" size="2">&lt;&lt;2012 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchyear&year=2013">   <b><font color="BLACK" size="2">&lt;&lt;2013</font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchyear&year=2014">   <b><font color="BLACK" size="2">&lt;&lt;2014 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchyear&year=2015">   <b><font color="BLACK" size="2">&lt;&lt;2015 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=01">   <b><font color="BLACK" size="2">&lt;&lt;01 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=02">   <b><font color="BLACK" size="2">&lt;&lt;02 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=03">   <b><font color="BLACK" size="2">&lt;&lt;03</font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=04">   <b><font color="BLACK" size="2">&lt;&lt;04 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=05">   <b><font color="BLACK" size="2">&lt;&lt;05 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=06">   <b><font color="BLACK" size="2">&lt;&lt;06</font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=07">   <b><font color="BLACK" size="2">&lt;&lt;07 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=08">   <b><font color="BLACK" size="2">&lt;&lt;08 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=09">   <b><font color="BLACK" size="2">&lt;&lt;09 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=10">   <b><font color="BLACK" size="2">&lt;&lt;10 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=11">   <b><font color="BLACK" size="2">&lt;&lt;11 </font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchmonth&month=12">   <b><font color="BLACK" size="2">&lt;&lt;12</font></b></a>
</td>
<td bgcolor="#FFFF88">
<a href="${pageContext.request.contextPath}/product.do?path=searchzong">   <b><font color="BLACK" size="2">&lt;&lt;显示总销量排行 </font></b></a>
</td>


</tr>
</table>

<p>

<center>
  <b><font size="4">Result</font></b>
</center>

<table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="3">

  <tr bgcolor="#CCCCCC">  <td><b>Item ID</b></td>  <td><b>Product ID</b></td>  <td><b>Description</b></td>  <td><b>List Price</b></td> <td>comments</td>  <td>&nbsp;</td>  </tr>
 
 <c:forEach items="${itemList}" var="item">
  <c:if test="${item.accountid != user.username}">
  <tr bgcolor="#FFFF88">
  <td><b>
<a href="${pageContext.request.contextPath}/item.do?path=addItemToCart&itemId=${item.itemid}">
 
 ${item.itemid}></a></b></td>
  <td>${item.productid}</td>
  <td>
  ${item.attr1}
  ${item.attr2}
  ${item.attr3}
  ${item.attr4}
  ${item.attr5}

    
   </td>
  <td>${item.listprice}</td>
  <td><a href="${pageContext.request.contextPath}/comment.do?path=show&itemid=${item.itemid}">comments for this</a>></td>
  <td><a href="${pageContext.request.contextPath}/item.do?path=addItemToCart&itemId=${item.itemid}&product"> 
  <img border="0" src="${pageContext.request.contextPath}/images/button_add_to_cart.gif" /></a></td>
  </tr>
  </c:if>
</c:forEach>
  <tr><td bgcolor="#FFFFFF" colspan="2">
 
    <a href="#"><img src="${pageContext.request.contextPath}/images/button_prev.gif" border="0"></a>

 
    <a href="#"><img src="${pageContext.request.contextPath}/images/button_next.gif" border="0"></a>
  </td></tr>
 
</table>

<%@include file="../common/IncludeBottom.jsp"%>