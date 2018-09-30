<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: benek
  Date: 29.09.18
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warsztat App</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<h2>List of employees</h2>
<a href="/employee/add">Add new Employee</a>
<table border="1">
    <tr>
        <th>id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Note</th>
        <th>Hour cost</th>
        <th colspan="3">Actions</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.address}</td>
            <td>${employee.phone}</td>
            <td>${employee.note}</td>
            <td>${employee.hourCost}</td>
            <td>
                <form action="/employee/orders" method="post">
                    <input type="hidden" name="employeeId" value="${employee.id}">
                    <input type="submit" value="View Orders">
                </form>
            </td>
            <td>
                <form action="/employee/edit" method="post">
                    <input type="hidden" name="employeeId" value="${employee.id}">
                    <input type="submit" value="Edit">
                </form>
            </td>
            <td>
                <form action="/employee/delete" method="post">
                    <input type="hidden" name="employeeId" value="${employee.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>

    </c:forEach>
</table>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
