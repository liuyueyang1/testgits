<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/3/12
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script>
                $(function () {
                    $("#username").blur(function () {
                                    var username = $(this).val();
                                    $.get("${pageContext.request.contextPath}/findUser",{username:username},function (data) {

                                var object = data.valueOf();
                                alert(object.html());
                                    //             alert(data.msg);
                                    //     if (data.username==username){
                                    //             //存在
                                    //         $("#span").css("color","red");
                                    //         $("#span").html(data.msg);
                                    //     } else {
                                    //         //不存在
                                    //         $("#span").css("color","green");
                                    //         $("#span").html(data.msg);
                                    //     }
                                    },"json");
                    });
                })
    </script>
</head>
<body>
        <!--导航栏信息-->
    <%@include file="header.jsp"%>
        ${msg}
<form action="${pageContext.request.contextPath}/customer/insert" method="post">
    <table align="center">
        <tr>
            <td>
                用户名称
            </td>
            <td>
                <input type="text" id="username" name="name" placeholder="输入用户名">
                <span id="span"></span>
            </td>
        </tr>
        <tr>
            <td>客户来源</td>
            <td> <input type="text" name="source" placeholder="请输入"> </td>
        </tr>
        <tr>
            <td>所属行业</td>
            <td>
                <input type="text" name="industry"  placeholder="请输入行业"/>
            </td>
        </tr>
        <tr>
            <td>
                客户级别
            </td>
            <td>
                <input type="text" name="level"  placeholder="请输入客户级别"/>
            </td>
        </tr>
        <tr>
            <td>
                联系人
            </td>
            <td>
                <input type="text" name="linkman"  placeholder="请输入联系人"/>
            </td>
        </tr>
        <tr>
            <td>
                固定电话
            </td>
            <td>
                <input type="text" name="phone"  placeholder="请输入固定电话"/>
            </td>
        </tr>
        <tr>
            <td>
                移动电话
            </td>
            <td>
                <input type="text" name="mobile"  placeholder="请输入移动电话"/>
            </td>
        </tr>
        <tr>
            <td>
                邮政编码
            </td>
            <td>
                <input type="text" name="zipcode"  placeholder="请输入邮政编码"/>
            </td>
        </tr>
        <tr>
            <td>
                联系地址
            </td>
            <td>
                <input type="text" name="address"  placeholder="请输入联系地址"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
<hr size="2" color="red">

        <%@include file="footer.jsp"%>
</body>
</html>