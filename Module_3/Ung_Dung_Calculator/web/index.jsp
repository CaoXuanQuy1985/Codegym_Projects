<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/14/20
  Time: 8:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ung Dung Calculator</title>
  </head>
  <body>
      <form method="get" action="/calculator">
          <label>First Operand: </label>
          <input type="text" name="operand1"/><br/>
        <label>Operator:</label>
        <select id="operator" name="operator">
          <option value="add">+</option>
          <option value="sub">-</option>
            <option value="multi">x</option>
            <option value="div">/</option>
        </select><br/>
          <label>Second Operand:</label>
          <input type="text" name="operand2"/><br/>
          <input type="submit"/>
          <p>Result: ${result}</p>
      </form>
  </body>
</html>
