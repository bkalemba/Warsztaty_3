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
<h2>List of customers</h2>
<table border="1">
    <tr>
        <td>id</td>
        <td>First name</td>
        <td>Last name</td>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
        </tr>

    </c:forEach>
</table>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
