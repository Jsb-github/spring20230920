<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-06
  Time: 오전 11:49
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
<h4>국가로 공급 조회</h4>
<table>
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>City</th>
        <th>Country</th>
    </tr>

    <c:forEach items="${suppliersList}" var="suppliers">
        <tr>
            <td>${suppliers.id}</td>
            <td>${suppliers.name}</td>
            <td>${suppliers.city}</td>
            <td>${suppliers.country}</td>
        </tr>
    </c:forEach>
</table>
    <div>
        <c:forEach begin="1" end="${lastPageNumber}" var="pageNumber">
            <a href="/main22/sub2?p=${pageNumber}">${pageNumber}</a>
        </c:forEach>
    </div>
</body>
</html>
