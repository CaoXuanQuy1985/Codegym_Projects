<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/13/20
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dang Nhap</title>
  </head>
  <body>
  <div id="page">
    <form method="get" action="http://localhost:8080/login">
      <label>Username:</label>
      <input type="text" name="username"/><br/>
      <label>Password:</label>
      <input type="password" name="password"/><br/>
      <input type="submit"/>
    </form>
  </div>
  </body>
</html>
