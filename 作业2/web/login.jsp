<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/28
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%--    <form action="MyServlet" method="post">--%>
<form id="login">
    <label for="username">用户名</label>
    <input type="text" name="username" id="username">
    <label for="password">密码</label>
    <input type="text" name="password" id="password">


    <%--      <input id="submit" type="submit" value="提交">--%>
</form>
<input id="submit" type="submit" value="提交">
</body>

<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script>
    $("#submit").on('click', function(){
        console.log("Success");
        $.ajax({
            type: 'POST',
            url: 'login',
            data: $("#login").serialize(),
            success: function(){
                console.log($("#login").serialize());
                alert("尝试登录!")
            },
            error: function(){
                console.log(222222)
                alert("登录失败!")
            }
        })
    })
</script>

</html>
