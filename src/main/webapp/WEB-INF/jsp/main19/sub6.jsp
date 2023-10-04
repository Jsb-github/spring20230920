<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-04
  Time: 오후 4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
            border: 1px solid black;
            width: 100%;
            text-align: center;
        }
        th, td{

            border: 1px solid black;
        }
        th{
            background-color: aqua;

        }

    </style>
</head>
<body>
    <h4>고객목록</h4>
<%--    table>tr>th*4--%>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>address</th>
            <th>country</th>
        </tr>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.country}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
