<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/13/20
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ung Dung Tu Dien Don Gian</title>
  </head>
  <body>
      <div id="page">
          <form method="get" action="/translate">
              <label>English</label>
              <input type="text" name="english"/><br/>
              <input type="submit"/>
              <p>Vietnamese: ${vietnamese}</p>
          </form>
      </div>
  </body>
</html>
