<%--
  Created by IntelliJ IDEA.
  User: Kylian
  Date: 2023/7/6
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in Success Page</title>
</head>
<body>
    <!-- Login success page -->
    <h1>Log in Success!</h1>
    <p>Current account: <%= request.getParameter("username") %></p>
    <a href="index.jsp">Back to home</a>
</body>
</html>
