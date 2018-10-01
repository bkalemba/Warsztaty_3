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
<h2>List of Customers</h2>
<a href="/customer/add">Add new Customer</a>
<table border="1">
    <tr>
        <td>id</td>
        <td>First name</td>
        <td>Last name</td>
        <td>Birth date</td>
        <th colspan="4">Actions</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.birthDate}</td>
            <td>
                <form action="/customer/vehicles" method="post">
                    <input type="hidden" name="customerId" value="${customer.id}">
                    <input type="submit" value="View Vehicles">
                </form>
            </td>
            <td>
                <form action="/customer/orders" method="post">
                    <input type="hidden" name="customerId" value="${customer.id}">
                    <input type="submit" value="View Orders">
                </form>
            </td>
            <td>
                <form action="/customer/edit" method="post">
                    <input type="hidden" name="customerId" value="${customer.id}">
                    <input type="submit" value="Edit">
                </form>
            </td>
            <td>
                <form action="/customer/delete" method="post">
                    <input type="hidden" name="customerId" value="${customer.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>

    </c:forEach>
</table>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
