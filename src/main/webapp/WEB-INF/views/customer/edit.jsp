<%--
  Created by IntelliJ IDEA.
  User: benek
  Date: 30.09.18
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warsztat App</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<h2>Edit of Customer</h2>
<form action="/customer/edit" method="post">
    <table border="0">
        <tr>
            <td>ID</td>
            <td><input type="text" name="Id" value="${customer.id}" disabled></td>
        </tr>
        <tr>
            <td>First name</td>
            <td><input type="text" name="firstName" value="${customer.firstName}"></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lastName" value="${customer.lastName}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="birthDate" value="${customer.birthDate}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
            <td><a href="/customer/list">Cancel</a></td>
        </tr>
    </table>
    <input type="hidden" name="customerId" value="${customer.id}">
    <input type="hidden" name="confirm" value="confirm">
</form>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
