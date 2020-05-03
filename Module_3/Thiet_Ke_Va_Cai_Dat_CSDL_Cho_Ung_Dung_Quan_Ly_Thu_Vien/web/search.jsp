<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/3/20
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Books</title>
</head>
<body>
<h1>SearchBooks</h1>

<form action="http://localhost:8080/Thiet_Ke_Va_Cai_Dat_CSDL_Cho_Ung_Dung_Quan_Ly_Thu_Vien_war_exploded/searchServlet" method="post">
    <table>
        <tr>
            <td>ISBN</td>
            <td><input type="text" name="isbn"/></td>
        </tr>

        <tr>
            <td>Nguoi Muon</td>
            <td><input type="text" name="student_number"/></td>
        </tr>

    </table>
    <input type="submit" value="Search"/>

</form>

<form action="UserSummary.php" method="post">
    <input type="submit" value="Back"/>
</form>

<form action="Login.php" method="post">
    <input type="submit" value="Close"/>
</form>
</body>
</html>
