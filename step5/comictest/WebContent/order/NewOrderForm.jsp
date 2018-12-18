<%@include file="../common/IncludeTop.jsp"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<script type="text/javascript" charset="utf-8">
function change()
{
	var objSel = document.getElementById("form1"); 
	var form2 = document.getElementById("form2"); 
	var table = document.getElementById("table"); 
	if(objSel.value=="card"){
		form2.options[0]= new Option("dragon","dragon");
		form2.options[1]= new Option("visa","visa");
		 var newTr = table.insertRow();  
		 var newTd0 = newTr.insertCell();        //添加两列               
		 var newTd1 = newTr.insertCell();
		 newTr.style.backgroundColor="#FFFF88";
		 
		 newTd1.innerHTML = '<input type="text" name="creditcard">';        
		 newTd0.innerText= 'Cardnumber';
		
	}else if(objSel.value=="balance"){
		form2.options[0]= new Option();
		form2.options[1]= new Option();
		table.deleteRow();
	}
}
</script>
</head>
<form method="post" action="${pageContext.request.contextPath}/orders.do?path=newOrder">
<table  id="table" align="center"bgcolor="#008800" border=0 cellpadding=3 cellspacing=1 bgcolor=#FFFF88>
<tr bgcolor=#FFFF88><td colspan=2 >

<FONT color=GREEN size=4><B>账单信息</B></FONT>
</td></tr>

<tr bgcolor=#FFFF88><td>
First name:</td><td><input type="text" name="billToFirstName" value="${account.firstname }" />
</td></tr>
<tr bgcolor=#FFFF88><td>
Last name:</td><td><input type="text" name="billToLastName" value="${account.lastname }"/>
</td></tr>
<tr bgcolor=#FFFF88><td>
Address 1:</td><td><input type="text" name="billAddress1" value="${account.addr1 }"/>
</td></tr>
<tr bgcolor=#FFFF88><td>
Address 2:</td><td><input type="text" name="billAddress2" value="${account.addr2 }"/>
</td></tr>
<tr bgcolor=#FFFF88><td>
City: </td><td><input type="text" name="billCity" value="${account.city }"/>
</td></tr>
<tr bgcolor=#FFFF88><td>
State:</td><td><input type="text" name="billState" value="${account.state }"/>
</td></tr>
<tr bgcolor=#FFFF88><td>
Zip:</td><td><input type="text" name="billZip" value="${account.zip }"/>
</td></tr>
<tr bgcolor=#FFFF88><td>
Country: </td><td><input type="text" name="billCountry" value="${account.country }"/>
</td></tr>
<tr bgcolor=#FFFF88><td>
Courier: </td><td><input type="text" name="courier" value="DebExpress"/>
</td></tr>
<tr bgcolor=#FFFF88><td>
Card or Balance: </td><td><select name="paymethod" id="form1" onchange="change()"> 
     <option value="card">card</option> 
     <option value="balance">balance</option>
     </select> 
</td></tr>
<tr bgcolor=#FFFF88><td>
Cardtype: </td><td><select name="cardtype" id="form2"> 
     <option value="dragon">dragon</option> 
     <option value="visa">visa</option>
     </select> 
</td></tr>
<tr bgcolor=#FFFF88><td>
Cardnumber: </td><td><input type="text" name="creditcard">
</td></tr>

</table>
<P>
<center>
<input  type="image" src="${pageContext.request.contextPath}/images/button_submit.gif">
</center>

</form>

<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
不要再点了！？
</p>