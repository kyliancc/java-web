<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login System</title>
</head>
<body>
    <h1>Login System Index</h1>

    <!--
        Get account info in session object.
    -->
    <p>Current Account: <%= request.getSession().getAttribute("username") %></p>

    <a href="login.jsp">Login</a>
    <br>
    <a href="register.jsp">Register</a>
</body>
</html>