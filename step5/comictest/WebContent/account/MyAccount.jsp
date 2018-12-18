<body>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common/IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>


<center>您可以进行订单和商品有关操作 </center>

<center>
<table  border=0 cellpadding=3 cellspacing=1
	>
	<TR >
		<TD>
			欢迎:
		</TD>
	   <TD>
	
            ${user.username}
		</TD>
	 </TR>
	<TR >
		<TD>
			神社余额:
		</TD>
		<TD>	     
	        ${account.balance}
		</TD>
	</TR>
	
		
	
 </table></center>
<center><a href="${pageContext.request.contextPath}/GoodsServlet?path=show">去看我的货物</a>&nbsp;       
 <a href="${pageContext.request.contextPath}/account/SellForm.jsp">卖新的东西</a> &nbsp;
  <a href="${pageContext.request.contextPath}/orderstatus.do?path=showmyorder">查看我的订单</a> &nbsp;
  <a href="${pageContext.request.contextPath}/orderstatus.do?path=showmystoreorder">查看商店订单</a> 
 </center>


<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
这里是你的商店 ！
</p>
</body>