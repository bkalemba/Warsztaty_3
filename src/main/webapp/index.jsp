<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: benek
  Date: 29.09.18
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warsztat App</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
Aktualnie prowadzone naprawy:
<table border="1">
    <tr>
        <td>ID</td>
        <td>Vehicle ID</td>
        <td>Employee ID</td>
        <td>Status</td>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.vehicle.brand} ${order.vehicle.model}</td>
            <td>${order.employee.firstName} ${order.employee.lastName}</td>
            <td>${order.status.description}</td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
