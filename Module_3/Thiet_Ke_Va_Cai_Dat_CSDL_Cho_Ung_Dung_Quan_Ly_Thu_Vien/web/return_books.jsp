<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/3/20
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Return Books</title>
</head>
<body>
<form action="http://localhost:8080/Thiet_Ke_Va_Cai_Dat_CSDL_Cho_Ung_Dung_Quan_Ly_Thu_Vien_war_exploded/returnServlet" method="post">
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
</body>
</html>
