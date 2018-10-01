<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: benek
  Date: 30.09.18
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warsztat App</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf" %>
<h2>Customer</h2>
<table border="1">
    <tr>
        <th>id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Birth date</th>
    </tr>
    <tr>
        <td>${customer.id}</td>
        <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
        <td>${customer.birthDate}</td>
    </tr>
</table>
<h2>Orders</h2>
<table border="1">
    <tr>
        <th>id</th>
        <th>Vehicle</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.vehicle.brand} ${order.vehicle.model}</td>
            <td>${order.status.description}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/views/jspf/footer.jspf" %>
</body>
</html>
