<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/3/12
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        function upon() {
            var usercode = $("#usercode").val();
            var password = $("#password").val();
            if (usercode == "" || password == "") {
                $("#message").text("账号密码不能为空");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <%@include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/loginServlet" method="post"
        onsubmit="return upon()">
    用户名: <input type="text" id="usercode" name="usercode" placeholder="输入用户名"><br/>
    密码: <input type="text"  id="password" name="password" placeholder="输入密码"><br/>
          <input type="radio" name="autoLogin" value="${60*2}" />自动登录
            <input type="submit" value="提交"><br/>
            <span id="message" style="color:red;">${msg}</span>
</form>

    <%@include file="footer.jsp"%>
</body>

</html>
