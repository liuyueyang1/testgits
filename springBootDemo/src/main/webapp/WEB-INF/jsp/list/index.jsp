
<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/3/12
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        #sy{
            color: red;

        }

    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script>
        function deletes(id) {
                    $.get("${pageContext.request.contextPath}/customer/delete",{"id":id},function (data) {
                                if (data="OK"){
                                    alert("客户删除成功");
                                    window.location.reload();
                                }else {
                                    alert("客户删除失败!");
                                    window.location.reload();;
                                }
                    });
        }

    </script>
</head>
<body>
<!--头部信息-->
    <%@ include file="header.jsp"%>
<!--正文内容-->

<div align="center"><h1 id="sy">这是首页</h1></div><br/>

<div id="name" name="username" align="center">欢迎：${user_session.name} 访问网址</div><br/>
<div align="center"><a href="${pageContext.request.contextPath}/list/regist.jsp">新注册用户</a></div>
<div align="center"><a href="${pageContext.request.contextPath}/list/login.jsp">登录</a></div>
<div align="center"><a href="${pageContext.request.contextPath}/loginOut">退出</a></div><br/>
-------------------------------------------

    <form action="${pageContext.request.contextPath}/customer/findAll" method="get">
        <label for="customerFrom">客户来源</label>
        <select id="customerFrom" name="customerFrom">
            <option value="">--请选择--</option>
            <c:forEach items="${fromType}" var="item">
                <option value="${item.item_name}">
                        ${item.item_name}
                </option>
            </c:forEach>
        </select>
        <label for="industry">所属行业</label>
        <select id="industry" name="industry">
            <option value="">--请选择--</option>
            <c:forEach items="${industryType}" var="item">
                <option value="${item.item_name}">
                        ${item.item_name}
                </option>
            </c:forEach>
        </select>
        <label for="level">客户级别</label>
        <select id="level" name="level">
            <option value="">--请选择--</option>
            <c:forEach items="${levelType}" var="item">
                <option value="${item.item_name}">
                        ${item.item_name}
                </option>
            </c:forEach>
        </select>
            <input type="submit" value="查询">
    </form>
<br/>
<a href="${pageContext.request.contextPath}/customer/toregist" >新建</a>
<br/>
    <table>
        <tr>
            <td>编号</td>
            <td>客户名称</td>
            <td>客户来源</td>
            <td>客户所属行业</td>
            <td>客户级别</td>
            <td>固定电话</td>
            <td>手机</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${customer}" varStatus="s" var="row">
        <tr>
            <td>${row.id}</td>
            <td>${row.name}</td>
            <td>${row.source}</td>
            <td>${row.industry}</td>
            <td>${row.level}</td>
            <td>${row.phone}</td>
            <td>${row.mobile}</td>
            <td>
                <a href="#" onclick="updates()()">更新</a>
                <a href="#" onclick="deletes(${row.id})">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>

<br/>
<!--底部信息-->
    <%@include file="footer.jsp"%>
</body>
</html>