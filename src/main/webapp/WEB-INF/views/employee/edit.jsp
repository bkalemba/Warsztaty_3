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
<h2>Edit of Employee</h2>
<form action="/employee/edit" method="post">
    <table border="0">
        <tr>
            <td>ID</td>
            <td><input type="text" name="Id" value="${employee.id}" disabled></td>
        </tr>
        <tr>
            <td>First name</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lastName" value="${employee.lastName}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${employee.address}"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="${employee.phone}"></td>
        </tr>
        <tr>
            <td>Note</td>
            <td><input type="text" name="note" value="${employee.note}"></td>
        </tr>
        <tr>
            <td>Hour cost</td>
            <td><input type="number" min="0" step="0.01" name="hourCost" value="${employee.hourCost}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
            <td><a href="/employee/list">Cancel</a></td>
        </tr>
    </table>
    <input type="hidden" name="employeeId" value="${employee.id}">
    <input type="hidden" name="confirm" value="confirm">
</form>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
