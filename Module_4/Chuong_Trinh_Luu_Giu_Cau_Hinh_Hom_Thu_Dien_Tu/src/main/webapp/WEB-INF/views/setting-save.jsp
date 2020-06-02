<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/2/20
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Setting Save</title>
</head>
<body>
<div id="container">
    <table>
        <thead>
            <tr>
                <th>Language</th>
                <th>Page Size</th>
                <th>Spam Filter</th>
                <th>Signature</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${settings}" var="setting">
            <tr>
                <td>${setting.language.name}</td>
                <td>${setting.pageSize.numberPage}</td>
                <td>${setting.getSpamFilter()}</td>
                <td>${setting.getSignature()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
