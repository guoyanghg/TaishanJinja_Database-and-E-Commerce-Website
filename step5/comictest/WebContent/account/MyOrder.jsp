<body>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common/IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<center>我的订单</center>

										<table border="0" cellspacing="0"
											cellpadding="5" width="100%">
											<tbody>
												<tr>
													<td>

														<b><i><font size="2" color="BLACK">订单号</font> </i> </b> &nbsp;
													</td>
													<td>

														<b><i><font size="2" color="BLACK">状态</font> </i> </b> &nbsp;
													</td>
													
													<td>

														<b><i><font size="2" color="BLACK">操作</font> </i> </b> &nbsp;
													</td>
												</tr>
												<c:forEach items="${listOrderstatus}" var="order">
												<tr>
													<td>
														
															<c:out value="${order.orderid}" escapeXml="false"/>
													
														
													</td>
													<td>
														
															<c:if test="${order.status == 'YF'}"> 
                                                                                                                                                                                     已发货
                                                    </c:if> 
                                                    <c:if test="${order.status == 'NF'}"> 
                                                                                                  未发货
                                                    </c:if> 
                                                    <c:if test="${order.status == 'OK'}"> 
                                                    交易完成
													 </c:if> 
									
													</td>
													
													<td>
													<c:if test="${order.status == 'YF'}"> 
                                                    <a href="${pageContext.request.contextPath}/orderstatus.do?path=updatetoyishouhuo&orderid=${order.orderid}">确认收货</a>
                                                    </c:if> 
                                                    <c:if test="${order.status == 'NF'}"> 
                                                    <a>等待卖家发货中.. </a>
                                                    </c:if> 
                                                    <c:if test="${order.status == 'OK'}"> 
                                                    <a href="${pageContext.request.contextPath}/comment.do?path=comment&orderid=${order.orderid}">订单成功,去评论！</a>
                                                    </c:if>
													</td>
															
												</tr>
												</c:forEach>
												
											</tbody>
										</table>
							


<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
我们要回主页在看看别的么！？
</p>
</body>