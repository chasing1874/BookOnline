<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>订单详情</title>
  <%-- 静态包含 base标签、css样式、jQuery文件 --%>
  <%@ include file="/pages/common/head.jsp"%>

</head>
<body>

<div id="header">
  <img class="logo_img" alt="" src="static/img/logo.gif" >
  <span class="wel_word">购物车</span>


  <%-- 静态包含 欢迎语 --%>

  <div>
    <%--    user是传过来的user对象，包含用户和密码等信息，在登录成功时被Servlet保存到session域中--%>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="orderServlet?action=${ empty param.MU ? "allOrders" : "myOrders"}&userId=${sessionScope.user.id}">返回</a>
  </div>

</div>

<div id="main">

  <table>
    <tr>
      <td>商品名称</td>
      <td>数量</td>
      <td>单价</td>
      <td>金额</td>
    </tr>


      <c:forEach items="${requestScope.orderDetails}" var="orderItem">
        <tr>
          <td>${orderItem.name}</td>
          <td>${orderItem.count}</td>
          <td>${orderItem.price}</td>
          <td>${orderItem.totalPrice}</td>
        </tr>
      </c:forEach>
  </table>


<%--    <div class="cart_info">--%>
<%--      <span class="cart_span">订单中共有<span class="b_count">${requestScope.myOrders}</span>件商品</span>--%>
<%--      <span class="cart_span">总金额<span class="b_price">${requestScope.orderDetails}</span>元</span>--%>
<%--    </div>--%>



</div>

<%-- 静态包含 页脚信息 --%>
<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>