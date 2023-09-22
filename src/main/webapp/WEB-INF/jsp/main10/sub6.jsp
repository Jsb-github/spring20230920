<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .tab1{
            border-collapse: collapse;;
            margin: 0 auto;
            width: 1200px;
            height: 500px;
            border: 1px solid black;
        }

        th{
            background-color: #eee;
        }

        th , td{
            padding: 5px;
        }
    </style>
</head>
<body>

    <table class="tab1">
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>LastName</th>
            <th>ClassName</th>
            <th>PhoneNumber</th>
        </tr>
        <c:forEach items="${list}" var="list" varStatus="status">
        <tr>
        <td>${list.id}</td>
        <td>${list.firstName}</td>
        <td>${list.lastName}</td>
        <td>${list.className}</td>
        <td>${list.phoneNumber}</td>
        </tr>
        </c:forEach>
    </table>

  </body>
</html>
