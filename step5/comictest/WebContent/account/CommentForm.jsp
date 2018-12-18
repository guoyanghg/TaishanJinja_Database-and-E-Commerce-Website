<%@include file="../common/IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<center>itemid:${commentOrder.itemid}&nbsp;seller:${commentOrder.sellerid}</center> 
<center>
<form action="${pageContext.request.contextPath}/comment.do?path=addcomment"
	method="post">
	<table bgcolor="#008800" border=0 cellpadding=3 cellspacing=1
	bgcolor=#FFFF88>
	<TR bgcolor=#FFFF88>
		<TD>
			Rating:
		</TD>
		<TD>
	<select name="rating"> 
     <option value="1">1</option> 
     <option value="2">2</option>
     <option value="3">3</option> 
     <option value="4">4</option> 
     <option value="5">5</option> 
      <option value="6">6</option> 
      <option value="7">7</option> 
      <option value="8">8</option> 
      <option value="9">9</option> 
      <option value="10">10</option>  
     </select> 

		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			Comment:
		</TD>
		<TD>	     
	     <input type="text" name="comment" />
		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			<input type="submit" value="Submit" name="Submit" />
		</TD>
		<TD>
			<input type="reset" value="Reset" name="Reset" />
		</TD>
	</TR>
	
	
	
 </table>
</form>
</center>
<%@include file="../common/IncludeBottom.jsp"%>