<body>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../common/IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>


										<table border="0" cellspacing="0"
											cellpadding="5" align=left width="50%">
											<tbody>
												<tr>
													<td>

														<b><i><font size="2" color="BLACK">货物号</font> </i> </b> &nbsp;
													</td>
													<td>

														<b><i><font size="2" color="BLACK">分类</font> </i> </b> &nbsp;
													</td>
													<td>

														<b><i><font size="2" color="BLACK">名称</font> </i> </b> &nbsp;
													</td>
										
												</tr>
												<c:forEach items="${goodList}" var="good">
												<tr>
													    <td>
														
															<c:out value="${good.itemid}" escapeXml="false"/>
													
														<br>
														
													</td>
													 <td>
														
															<c:out value="${good.productid}" escapeXml="false"/>
													
														<br>
														
													</td>
													<td>
														
															<c:out value="${good.attr5}" escapeXml="false"/>
													
														<br>
														
													</td>
												
												</tr>
												</c:forEach>
												
											</tbody>
										</table>
										
										
										
										
										<table border="0" cellspacing="0"
											cellpadding="5"  width="50%">
											<tbody>
												<tr>
													
													<td>

														<b><i><font size="2" color="BLACK">库存量</font> </i> </b> &nbsp;
													</td>
													<td>

														<b><i><font size="2" color="BLACK">评价</font> </i> </b> &nbsp;
													</td>
												</tr>
												<c:forEach items="${inventoryList}" var="inventory">
												<tr>
													    
													<td>
														
															<c:out value="${inventory.qty}" escapeXml="false"/>
													
														<br>
														
													</td>
													<td>
														
															<a href="${pageContext.request.contextPath}/comment.do?path=show&itemid=${inventory.itemid}">查看评论</a>
													</td>
												</tr>
												</c:forEach>
												
											</tbody>
										</table>
							


<%@include file="../common/IncludeBottom.jsp"%>
</body>