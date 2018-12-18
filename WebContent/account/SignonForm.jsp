<%@include file="../common/IncludeTop.jsp"%>

<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<form action="${pageContext.request.contextPath}/signon.do?path=signon"
	method="post">
	<table align="center" border="0">
		<tr>
			<td colspan="2">
				Please enter your username and password.
				<br />
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				Username:
			</td>
			<td>
				<input type="text" name="username"  />
			</td>
		</tr>
		<tr>
			<td>
				Password:
			</td>
			<td>
				<input type="password" name="password"  />
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
			<td>
				<input type="image" border="0"
					src="${pageContext.request.contextPath}/images/button_submit.gif" />
			</td>
		</tr>
	</table>
</form>
<center>

	<a href="${pageContext.request.contextPath}/account/NewAccountForm.jsp">
		<img border="0"
			src="${pageContext.request.contextPath}/images/button_register_now.gif" />
	</a>

</center>


<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
要登录才可以的！？
</p>

		