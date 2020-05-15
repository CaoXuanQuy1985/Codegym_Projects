<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/15/20
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .message {
        color: green;
    }
</style>
<html>
<head>
    <title>Create New Customer</title>
</head>
<body>
    <div id="page">
        <h1>Create New Customer</h1>
        <P>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </P>
        <p>
            <a href="/customers">Back To Customers</a>
        </p>
        <form method="post">
            <fieldset>
                <legend>
                    Customer Information
                </legend>
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" id="name"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" id="email"/></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="address" id="address"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Create Customer" /></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</body>
</html>
