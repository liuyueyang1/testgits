<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/4/23
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        <!--入口函数-->
    </script>
</head>
<body>

<form id="form" action="${pageContext.request.contextPath}/user/maventest" method="get">
   <table id="tbl">
    <tr>
        <td>编号</td>
        <td>客户名称</td>
        <td>客户密码</td>
        <td>客户邮箱</td>
        <td>客户生日</td>
        <td>
            <input type="submit" value="提交">
        </td>
    </tr>
        <c:forEach items="${users}" varStatus="s" var="row">
        <tr>
            <td>${row.id}</td>
            <td>${row.name}</td>
            <td>${row.password}</td>
            <td>${row.email}</td>
            <td>${row.birthday}</td>
            <td>
                <a href="#" onclick="updates()">更新</a>
                <a href="#" onclick="deletes()">删除</a>
            </td>

        </tr>
        </c:forEach>
</table>
</form>
</body>
</html>
