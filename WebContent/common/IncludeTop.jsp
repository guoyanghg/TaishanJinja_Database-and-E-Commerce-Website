
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Comic&nbsp;Store!</title>
</head>
	

	<body bgcolor="white">

		<table
			background="${pageContext.request.contextPath}/images/bkg-topbar.gif"
			border="0" cellspacing="0" cellpadding="5" width="100%">
			<tbody>
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/index.do"><img
								border="0"
								src="${pageContext.request.contextPath}/images/logo-topbar.gif" />
						</a>
					</td>
					<td align="right">
						<a href="${pageContext.request.contextPath}/item.do?path=viewCart"><img
								border="0" name="img_cart"
								src="${pageContext.request.contextPath}/images/cart.gif" />
						</a>
						<img border="0"
							src="${pageContext.request.contextPath}/images/separator.gif" />
						<c:choose>
							<c:when test="${empty user}">
								<a
									href="${pageContext.request.contextPath}/signon.do?path=checkSignon">
									<img border="0" name="img_signin"
										src="${pageContext.request.contextPath}/images/sign-in.gif" />
								</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/signon.do?path=off">
									<img border="0" name="img_signout"
										src="${pageContext.request.contextPath}/images/sign-out.gif" />
								</a>
							</c:otherwise>
						</c:choose>
						<img border="0"
							src="${pageContext.request.contextPath}/images/separator.gif" />
						<a href="${pageContext.request.contextPath}/signon.do?path=account">
							<img border="0" name="img_myaccount"
								src="${pageContext.request.contextPath}/images/my_account.gif" />
						</a>
						<img border="0"
							src="${pageContext.request.contextPath}/images/separator.gif" />
						<a href="${pageContext.request.contextPath}/help.html"><img
								border="0" name="img_help"
								src="${pageContext.request.contextPath}/images/help.gif" />
						</a>
					</td>
					<td align="left" valign="bottom">

						<form method="post" action="${pageContext.request.contextPath}/product.do?path=search">

							<input type="text" name="keyword" size="14" />
							&nbsp;
							<input border="0"
								src="${pageContext.request.contextPath}/images/search.gif"
								type="image" />
						</form>
					</td>
				</tr>
			</tbody>
		</table>
  </body>
  </html>
<%@include file="../common/IncludeQuickHeader.jsp"%>