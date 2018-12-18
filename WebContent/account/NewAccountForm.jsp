<%@include file="../common/IncludeTop.jsp"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<form action="${pageContext.request.contextPath}/signon.do?path=add" method="post">
<table cellpadding=10 cellspacing=0 align=center border=1 bgcolor=#dddddd><TR><TD>


<FONT color=darkgreen><H3>User Information</H3></FONT>
<table bgcolor="#008800" border=0 cellpadding=3 cellspacing=1 bgcolor=#FFFF88>
<TR bgcolor=#FFFF88><TD>
User ID:</TD><TD><input type="text" name="username" />
</TD></TR><TR bgcolor=#FFFF88><TD>
New password:</TD><TD><input type="password" name="newpassword" />
</TD></TR><TR bgcolor=#FFFF88><TD>
Repeat password:</TD><TD><input type="password" name="repassword" />
</TD></TR>
</table>

<%@include file="../account/IncludeAccountFields.jsp"%>

</table>

<BR><CENTER>
<input border=0 type="image" src="../images/button_submit.gif" />
</CENTER>

</form>

<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
欢迎加入我们！
</p>
