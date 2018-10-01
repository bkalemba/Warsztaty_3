<%--
  Created by IntelliJ IDEA.
  User: benek
  Date: 30.09.18
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warsztat App</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<form action="/customer/add" method="post">
    <table border="0">
        <tr>
            <td>First name</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td>Birth date</td>
            <td><input type="text" name="birthDate"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"></td>
            <td><a href="/customer/list">Cancel</a></td>
        </tr>
    </table>
</form>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
