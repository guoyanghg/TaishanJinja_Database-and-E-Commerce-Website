<body>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../common/IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>


<table border="0" cellspacing="0"
											cellpadding="5" width="100%">
											<tbody>
												<tr>
													<td>

														<b><i><font size="2" color="BLACK">评价用户</font> </i> </b> &nbsp;
													</td>
													<td>

														<b><i><font size="2" color="BLACK">评论内容</font> </i> </b> &nbsp;
													</td>
													<td>

														<b><i><font size="2" color="BLACK">评价得分</font> </i> </b> &nbsp;
													</td>
											
												</tr>
												<c:forEach items="${commentList}" var="comment">
												<tr>
													    <td>
														
															<c:out value="${comment.userid}" escapeXml="false"/>
													
														<br>
														
													</td>
													 <td>
														
															<c:out value="${comment.content}" escapeXml="false"/>
													
														<br>
														
													</td>
													 <td>
														
															<c:out value="${comment.rating}" escapeXml="false"/>
													
														<br>
														
													</td>
													
												</tr>
												</c:forEach>
												
											</tbody>
										</table>





<center>总销量:${commentcount}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均星级:${commentrating}</center>










<%@include file="../common/IncludeBottom.jsp"%>
</body>