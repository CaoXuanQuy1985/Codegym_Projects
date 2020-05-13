<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/13/20
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ung Dung Chuyen Doi Tien Te</title>
  </head>
  <body>
      <div id="page">
          <h1>Ung Dung Chuyen Doi Tien Te</h1>
        <form method="get" action="/convert">
            <label>USD: </label>
            <input type="text" name="usd"/><br/>
            <label>Ty Gia: </label>
            <input type="text" name="ratio"/><br/>
            <input type="submit"/>
            <label>VND</label>
            <p>Doi ra tien Viet Nam = ${result}</p>
        </form>
      </div>
  </body>
</html>
