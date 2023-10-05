<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-05
  Time: 오후 2:48
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
<h4>가격으로 상품 조회</h4>
<table>
    <tr>
        <th>상품</th>
        <th>가격</th>
    </tr>

    <c:forEach items="${productsList}" var="products">
        <tr>
            <td>${products.name}</td>
            <td>${products.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
