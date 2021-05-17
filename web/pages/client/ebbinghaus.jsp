<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fine
  Date: 2021/5/15
  Time: 5:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TodoList</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1>今日复习内容如下</h1><br>
    <c:forEach items="${requestScope.ebList}" var="todo">
        <c:if test="${not empty todo.info}">
            任务：<a href="https://${todo.href}">${todo.info}</a><br/>
        </c:if>
    </c:forEach>


    <br>
    <br>
    <br>
    <br>

    <h1>今日已学习内容：</h1><br/>
    <form action="ebServlet" method="get" >
        <input type="hidden" name="action" value="addEb">
        <table>
            <tr>
                <td>学习内容：<input name="ebInfo" type="text" value=""></td>
                <td>链接：<input name="ebHref" type="text" value=""></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>

</body>
</html>
