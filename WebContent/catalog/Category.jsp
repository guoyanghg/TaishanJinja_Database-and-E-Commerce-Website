<%@include file="../common/IncludeTop.jsp"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table align="left" bgcolor="#008800" border="0" cellspacing="2"
	cellpadding="2">
	<tr>
		<td bgcolor="#FFFF88">
			<a href="index.do"><b><font color="BLACK" size="2">&lt;&lt;
						Main Menu</font>
			</b>
			</a>
		</td>
	</tr>
</table>
<p>
<center>
	<h2></h2>
</center>
<table align="center" bgcolor="#008800" border="0" cellspacing="2"
	cellpadding="3">
	<tr bgcolor="#CCCCCC">
		<td>
			<b>Product ID</b>
		</td>
		<td>
			<b>Name</b>
		</td>
	</tr>

	<c:forEach items="${productList}" var="product">
		<tr bgcolor="#FFFF88">
			<td>
				<b><a
					href="${pageContext.request.contextPath}/product.do?path=show&productId=${product.productid}"><font
						color="BLACK">${product.productid}></font>
				</a>
				</b>
			</td>
			<td>
				${product.name}
			</td>
		</tr>
	</c:forEach>

	<tr>
		<td bgcolor="#FFFFFF" colspan="2">

			<a href="#"><img
					src="${pageContext.request.contextPath}/images/button_prev.gif"
					border="0">
			</a>


			<a href="#"><img
					src="${pageContext.request.contextPath}/images/button_next.gif"
					border="0">
			</a>

		</td>
	</tr>
</table>

<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
有很多好东西的！？
</p>


