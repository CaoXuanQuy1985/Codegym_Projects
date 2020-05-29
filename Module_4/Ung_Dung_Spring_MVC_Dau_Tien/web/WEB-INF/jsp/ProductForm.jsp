<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/27/20
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
</head>
<body>
    <div id="global">
        <form action="/save-product" method="post">
            <fieldset>
                <legend>Add A Product</legend>
                <label for="name">Product Name:</label>
                <input type="text" id="name" name="name" value="" tabindex="1"/>
                <label for="description">Product Description:</label>
                <input type="text" id="description" name="description" tabindex="2"/>
                <label fro="price">Price: </label>
                <input type="text" id="price" name="price" tabindex="3"/>
                <div id="buttons">
                    <label></label>
                    <input type="reset" id="reset" tabindex="4"/>
                    <input type="submit" id="submit" tabindex="5" value="Add Product"/>
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>
