<%@include file="../common/IncludeTop.jsp"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table align="left" bgcolor="#008800" border="0" cellspacing="2"
	cellpadding="2">
	<tr>
		<td bgcolor="#FFFF88">
			<a
				href="${pageContext.request.contextPath}/product.do?path=show&productId=${product.productid}">
				<b><font color="BLACK" size="2">&lt;&lt; ${product.name}</font>
			</b>
			</a>
		</td>
	</tr>
</table>

<p>
<table align="center" bgcolor="#008800" cellspacing="2" cellpadding="3"
	border="0" width="60%">
	<tr bgcolor="#FFFF88">
		<td width="100%" bgcolor="#cccccc">
			${item.itemid}
			<b></b>
		</td>
	</tr>
	<tr bgcolor="#FFFF88">
		<td>
			<b><font size="4"> ${item.attr1} ${item.attr2}
					${item.attr3} ${item.attr4} ${item.attr5}  </font>
			</b>
		</td>
	</tr>
	<tr bgcolor="#FFFF88">
		<td>
			<font size="3">${product.name}
			</font>
		</td>
	</tr>
	<tr bgcolor="#FFFF88">
		<td>
			<c:choose>
				<c:when test="${inventory.qty}==0">
					<font color="RED" size="2"><i>没货</i>
					</font>
				</c:when>
				<c:otherwise>
					<font size="2">有货 &nbsp;${inventory.qty}件</font>
				</c:otherwise>
			</c:choose>

		</td>
	</tr>
	<tr bgcolor="#FFFF88">
		<td>
			${item.listprice}

		</td>
	</tr>

	<tr bgcolor="#FFFF88">
		<td>
			<a
				href="${pageContext.request.contextPath}/item.do?path=addItemToCart&itemId=${item.itemid}">

				<img border="0"
					src="${pageContext.request.contextPath}/images/button_add_to_cart.gif" />
			</a>
		</td>
	</tr>
</table>


<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
不要买太多 会剁手的！！
</p>


	