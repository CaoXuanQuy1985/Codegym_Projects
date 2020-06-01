<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/1/20
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

    <meta charset="UTF-8">

    <title>Upload Result</title>

</head>

<body>

<jsp:include page="_menu.jsp"/>

<h3>Uploaded Files:</h3>

Description: ${description}

<br/>

<c:forEach items="${uploadedFiles}" var="file">

    ${file} <br>

</c:forEach>

</body>

</html>
