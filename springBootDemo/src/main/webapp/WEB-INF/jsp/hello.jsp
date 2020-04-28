<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/4/4
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">

        $(function () {
            $.get("${pageContext.request.contextPath}/test1",{},function (data) {
                var username = $("#username");
                for (var key in data){
                    alert(key[data])
                }
                $(data).each(function () {
                    var option="<option>"+data+"</option>";
                    alert(option)
                    username.append(option);
                });
            },"json");
        });



        ;
    </script>
</head>
<body>
<select id="username">
    <option>---请选择姓名---</option>

</select>
</body>
</html>
