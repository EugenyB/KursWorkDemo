<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.08.2018
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <jsp:useBean id="user" type="beans.User" scope="session"/>
    <h1>Hello, ${user.login}</h1>
</body>
</html>
