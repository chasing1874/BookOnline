<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>

	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>

		<%-- 静态包含 欢迎语 --%>
		<%@ include file="/pages/common/login_success_menu.jsp"%>

	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:if test="${empty requestScope.myOrders}">
				<td colspan="5"><a href="index.jsp">穷狗，购物车空空如也==</a>  </td>
			</c:if>
			<c:if test="${not empty requestScope.myOrders}">
				<c:forEach items="${requestScope.myOrders}" var="myOrder">
					<tr>
						<td>${myOrder.createTime}</td>
						<td>${myOrder.price}</td>
						<td>
							<c:choose>
								<c:when test="${myOrder.status==0}">未发货</c:when>
								<c:when test="${myOrder.status==1}"><a href="orderServlet?action=receiveOrder&orderId=${myOrder.orderId}&userId=${sessionScope.user.id}">确认收货</a> </c:when>
								<c:when test="${myOrder.status==2}">已签收</c:when>
							</c:choose>
						</td>
						<td><a href="orderServlet?action=orderDetails&orderId=${myOrder.orderId}&MU=User">查看详情</a></td>
					</tr>
				</c:forEach>
			</c:if>


		</table>
		
	
	</div>

	<%-- 静态包含 页脚信息 --%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>