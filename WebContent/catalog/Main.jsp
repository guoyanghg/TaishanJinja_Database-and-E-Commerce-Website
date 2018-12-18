<%@include file="../common/IncludeTop.jsp"%>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="0" cellspacing="2" cellpadding="0" width="100%">
	<tr>
		<td valign="top" width="100%">

			<table align="left" border="0" cellspacing="0" width="80%">
				<tbody>
					<tr>
						<td valign="top">
							<table  border="0" cellspacing="2"
								cellpadding="0" width="100%">
								<tr>
									<td>
										<table  border="0" cellspacing="0"
											cellpadding="5" width="200">
											<tbody>
												<tr>
													<td>

														<b><i><font size="2" color="BLACK">Welcome
																	${account.firstname}</font> </i> </b> &nbsp;
													</td>
												</tr>
												<c:forEach items="${categroyList}" var="category">
												<tr>
													<td>
														<a
															href="${pageContext.request.contextPath}/category.do?path=show&categoryId=${category.catid}">
															${category.name}yo!
														</a>
														
													</td>
												</tr>
												</c:forEach>
												
											</tbody>
										</table>
									</td>
								</tr>
							</table>

						</td>
						<td align="center" bgcolor="white" height="300" width="100%">

							<!-- MAIN IMAGE -->

							<map name="estoremap">
								<area alt="Birds" coords="72,2,280,250"
									href="${pageContext.request.contextPath}/category.do?path=show&categoryId=CD"
									shape="RECT" />
								<area alt="Fish" coords="4,182,74,252"
									href="${pageContext.request.contextPath}/category.do?path=show&categoryId=SOUVENIR"
									shape="RECT" />
								<area alt="Dogs" coords="61,249,131,319"
									href="${pageContext.request.contextPath}/category.do?path=show&categoryId=MODEL"
									shape="RECT" />
								<area alt="Reptiles" coords="140,270,210,340"
									href="${pageContext.request.contextPath}/category.do?path=show&categoryId=TICKETS"
									shape="RECT" />
								<area alt="Cats" coords="225,240,295,310"
									href="${pageContext.request.contextPath}/category.do?path=show&categoryId=BOOKS"
									shape="RECT" />
								<area alt="Birds" coords="279,182,349,252"
									href="${pageContext.request.contextPath}/category.do?path=show&categoryId=CD"
									shape="RECT" />
							</map>
							<img border="0" height="355"
								src="${pageContext.request.contextPath}/images/splash.gif"
								align="center" usemap="#estoremap" width="350" />
						</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>

</table>

<p align="center">
<a href="${pageContext.request.contextPath}/index.do"><img width=100 height=140 border="0"  src="${pageContext.request.contextPath}/images/moi.jpg" /></a>
这里是主页！点我的话会回到这里哦！
</p>

