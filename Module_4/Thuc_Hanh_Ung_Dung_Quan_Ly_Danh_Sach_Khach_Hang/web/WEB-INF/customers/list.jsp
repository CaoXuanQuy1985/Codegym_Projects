<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    long count = customerService.count();
    List<Customer> customers = customerService.findAll();
%>--%>
<html>
<head>
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
<%--There are <%= count %> customer(s) in list.--%>
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <%--<% for (Customer c : customers) { %>
    <tr>
        <td>
            <%= c.getId() %>
        </td>
        <td>
            <a href="info.jsp?id=<%= c.getId() %>"><%= c.getName() %></a>
        </td>
        <td>
            <%= c.getEmail() %>
        </td>
        <td>
            <%= c.getAddress() %>
        </td>
    </tr>
    <% } %>--%>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td><a href="/edit-customer/${customer.getId()}"> ${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>