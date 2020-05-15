<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/15/20
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
    <div id="page">
        <h1>Edit Customer</h1>
        <p>
            <c:if test='${requestScope["message"]} != null'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p>
        <p><a href="/customers">Back To Customer List</a></p>
        <form method="post">
            <fieldset>
                <legend>
                    Customer Information
                </legend>
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" value='${requestScope["customer"].getName()}'/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" value='${requestScope["customer"].getEmail()}'/></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="address" value='${requestScope["address"].getAddress()}'/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Update Customer"/></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</body>
</html>
