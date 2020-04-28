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
            $.get("${pageContext.request.contextPath}/findAll",{},function (data) {
                        var username = $("#username");
                        for (var i=0;i<data.data.length;i++){
                                var datum = data.data[i];
                                    var username1 = datum.username;
                            var option="<option>"+username1+"</option>";
                            username.append(option);
                            // for (var key in datum){
                            //     alert(datum[key])
                            // }
                        }
                //    $(data.data).each(function () {
                //
                //     alert(option)
                //
                // });
            },"json");
                  });
    </script>
</head>
<body>
            <select id="username">
                <option>---请选择姓名---</option>

            </select>
</body>
</html>
