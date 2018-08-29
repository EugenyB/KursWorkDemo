<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.08.2018
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <jsp:useBean id="user" class="beans.User" scope="session"/>
    <c:if test="${user.id==0}">
    <form action="login.html" method="post">
      <input type="text" name="login" title="login" required >
      <input type="password" name="password" title="password">
      <input type="submit" name="button" value="Register">
      <input type="submit" name="button" value="Sign In">
    </form>
    </c:if>
    <c:if test="${user.id > 0}">
      <h1>${user.login}</h1>
      <form action="signout.html">
        <input type="submit" value="SignOut">
      </form>
    </c:if>
  </body>
</html>
