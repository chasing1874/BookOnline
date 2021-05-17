<%--
  Created by IntelliJ IDEA.
  User: fine
  Date: 2021/5/5
  Time: 3:04 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<%--    user是传过来的user对象，包含用户和密码等信息，在登录成功时被Servlet保存到session域中--%>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>

    <a href="orderServlet?action=myOrders&userId=${sessionScope.user.id}">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
