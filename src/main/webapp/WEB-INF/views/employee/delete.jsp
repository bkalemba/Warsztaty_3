<%--
  Created by IntelliJ IDEA.
  User: benek
  Date: 30.09.18
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warsztat App</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<h2>Are you sure you want to delete this Employee?</h2>
<form action="/employee/delete" method="post">
    <table border="1">
        <tr>
            <th>id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Note</th>
            <th>Hour cost</th>
        </tr>
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.address}</td>
            <td>${employee.phone}</td>
            <td>${employee.note}</td>
            <td>${employee.hourCost}</td>
        </tr>
    </table>
    <input type="hidden" name="employeeId" value="${employee.id}">
    <input type="hidden" name="confirm" value="confirm">
    <table border="0">
        <tr>
            <td><input type="submit" value="Delete"></td>
            <td><a href="/employee/list">Cancel</a></td>
        </tr>
    </table>
</form>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>