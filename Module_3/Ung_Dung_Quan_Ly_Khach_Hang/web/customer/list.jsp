<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/15/20
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <div id="page">
        <h1> Customer List</h1>
        <p><a href="customers?action=create">Create a new Customer</a></p>
        <table>
            <tr>
                <td>Name</td>
                <td>Email</td>
                <td>Address</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach items='${requestScope["customers"]}' var="customer">
                <tr>
                    <td><a href="customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getAddress()}</td>
                    <td><a href="customers?action=edit&id=${customer.getId()}">Edit</a></td>
                    <td><a href="customers?action=delete&id=${customer.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
