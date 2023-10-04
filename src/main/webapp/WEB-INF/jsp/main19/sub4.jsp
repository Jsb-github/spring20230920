<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-04
  Time: 오후 3:17
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

        th{
            background-color: #eeeeee;
        }
    </style>
</head>
<body>
<h4>고객 목록</h4>
<%--    table>th>td*4--%>
<table >
    <tr>
    <th>CustomerID</th>
    <th >ContactName</th>
    <th>City</th>
    <th>Country</th>
    </tr>
    <c:forEach items="${customers}" var="customers">
     <tr>
         <td>${customers.id}</td>
         <td>${customers.name}</td>
         <td>${customers.city}</td>
         <td>${customers.country}</td>
     </tr>
    </c:forEach>
</table>
</body>
</html>
