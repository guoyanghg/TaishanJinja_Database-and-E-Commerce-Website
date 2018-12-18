
<%@include file="../common/IncludeTop.jsp"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<head>
<script type="text/javascript" charset="utf-8">
function change()
{
	var objSel = document.getElementById("form1"); 
	var form2 = document.getElementById("form2"); 
	if(objSel.value=="CD"){
		form2.options[0]= new Option("音乐CD","000001");
		form2.options[1]= new Option("动漫CD","000002");
		form2.options[0].selected=true;
	}else if(objSel.value=="BOOKS"){
		form2.options[0]= new Option("小说","000003");
		form2.options[1]= new Option("漫画","000004");
		form2.options[2]= new Option("海报","000005");
		form2.options[3]= new Option("杂志","000006");
		form2.options[0].selected=true;
	}else if(objSel.value=="MODEL"){
		form2.options[0]= new Option("DIY手办","000007");
		form2.options[1]= new Option("成品手办","000008");
		form2.options[0].selected=true;
	}else if(objSel.value=="SOUVENIR"){
		form2.options[0]= new Option("卡贴","000009");
		form2.options[1]= new Option("杯子","000010");
		form2.options[2]= new Option("钱包","000011");
		form2.options[3]= new Option("小伞","000012");
		form2.options[4]= new Option("钥匙环","000013");
		form2.options[0].selected=true;
		
	}else if(objSel.value=="TICKETS"){
		
		form2.options[0]= new Option("演唱会","000014");
		form2.options[1]= new Option("cosplay show","000015");
		form2.options[2]= new Option("动漫电影","000016");
		form2.options[0].selected=true;
		
	}
}
</script>
</head>


<form action="${pageContext.request.contextPath}/sell.do"
	method="post">
	<center>
	<table bgcolor="#008800" border=0 cellpadding=3 cellspacing=1
	bgcolor=#FFFF88>
	<TR bgcolor=#FFFF88>
		<TD>
			catagory:
		</TD>
		<TD>
	<select name="category" onchange="change()" id="form1"> 
     <option value="CD">CD</option> 
     <option value="BOOKS">BOOKS</option>
     <option value="MODEL">MODEL</option> 
     <option value="SOUVENIR">SOUVENIR</option> 
     <option value="TICKETS">TICKETS</option>  
     </select> 

		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			product:
		</TD>
		<TD>
	 <select name="product" id="form2"> 
     <option value="000001">音乐CD</option> 
     <option value="000002">动漫CD</option>
     </select> 

		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			listprice:
		</TD>
		<TD>
			<input type="text" name="listprice" />
		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			attribute1:
		</TD>
		<TD>
			<input type="text" name="attribute1" />
		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			attribute2:
		</TD>
		<TD>
			<input type="text" name="attribute2" />
		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			attribute3:
		</TD>
		<TD>
			<input type="text" name="attribute3" />
		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			attribute4:
		</TD>
		<TD>
			<input type="text" name="attribute4" />
		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			name:
		</TD>
		<TD>
			<input type="text" name="attribute5" />
		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			quantity:
		</TD>
		<TD>
			<input type="text" name="quantity" />
		</TD>
	</TR>
	<TR bgcolor=#FFFF88>
		<TD>
			status:
		</TD>
		<TD>
			<select name="status"> 
        <option value="0">NEW</option> 
        <option value="1">OLD</option>
    
     </select> 
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
    
    </center>

</form>
<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
要好好填写哦！卖的东西
</p>

