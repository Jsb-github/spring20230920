<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-05
  Time: 오후 4:42
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
    <th>주소</th>
    <th>City</th>
    <th>Country</th>
    <th>전화번호</th>
  </tr>

  <c:forEach items="${suppliersList}" var="suppliers">
    <tr>
      <td>${suppliers.id}</td>
      <td>${suppliers.name}</td>
      <td>${suppliers.address}</td>
      <td>${suppliers.city}</td>
      <td>${suppliers.country}</td>
      <td>${suppliers.phone}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
