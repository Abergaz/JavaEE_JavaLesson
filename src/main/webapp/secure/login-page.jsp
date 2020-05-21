<%--
  Created by IntelliJ IDEA.
  User: ZBook
  Date: 21.05.2020
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
Это form-login-page
<br>
<form action="j_security_check" method="post">
   User name: <input type="text" name="j_username"></br>
   Password: <input type="password" name="j_password"></br>
   <input type="submit" value="войти">
</form>
</body>
</html>
