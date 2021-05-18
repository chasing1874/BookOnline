

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
    <script type="text/javascript">
        $(function () {
            $("#sub_btn1").click(function (){
                var info = $("#ebInfo").val();
                info = $.trim(info);
                if (info == null || info == "") {
                    alert("请填写今日学习内容噢")
                    return false;
                }
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">Today——Todo</span>
</div>

<div id="main">

    <table>
        <tr>
            <td>任务</td>
            <td>点击复习⬇</td>
        </tr>
            <c:forEach items="${requestScope.ebList}" var="todo">

                <c:if test="${not empty todo.info}">
                    <tr>
                        <td>任务</td>
                        <td><a href="https://${todo.href}">${todo.info}</a></td>
                    </tr>
                </c:if>
            </c:forEach>
    </table>
<div/>
<div>
    <hr>

    <form action="ebServlet" method="get" >
        <input type="hidden" name="action" value="addEb">
        <table>
            <th colspan="3">今日已学习内容</th>
            <tr>
                <td>学习内容：<input id="ebInfo" name="ebInfo" type="text" value=""></td>
                <td>链接：<input id="ebHref" name="ebHref" type="text" value=""></td>
                <td><input id="sub_btn1" type="submit" value="起飞"></td>
            </tr>
        </table>
    </form>

</div>
<%-- 静态包含 页脚信息 --%>
</body>
</html>