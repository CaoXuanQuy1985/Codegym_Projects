<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/2/20
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting Form</title>
</head>
<body>
<div id="setting-container">
    <h1>Configuration Setting Email Personal</h1>
    <form:form commandName="setting" action="/save-setting" method="post">
        <fieldset>
            <legend>Setting Email</legend>
            <form:hidden path="id_Setting"/>
            <p>
                <label for="language">Languages:</label>
                <form:select id="language" path="language.id_Language" items="${languages}"
                 itemLabel="name" itemValue="id_Language"/>
            </p>
            <p>
                <label for="size">Page Sizes:</label>
                Show <form:select id="size" path="pageSize.id_PageSize" items="${pageSizes}"
                itemLabel="numberPage" itemValue="id_PageSize"/> emails per page
            </p>
            <p>
                <label>Spam Filter: </label>
                <form:checkbox path="spamFilter" value="spamFilter"/> Enable Spam Filter
            </p>
            <p>
                <label>Signature: </label>
                <form:textarea path="signature" tabindex="5" rows="10" cols="40"/>
            </p>
            <p id="buttons">
                <input id="submit" type="submit" tabindex="5" value="save"/>
                <input id="reset" type="reset" tabindex="4"/>
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
