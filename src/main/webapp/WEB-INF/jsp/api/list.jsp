<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-10
  Time: 오후 6:14
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
            width: 100%;
            text-align: center;
        }
        th{
            background-color: skyblue;
        }
        table,th,td{
            border: 1px solid black;
        }
    </style>

</head>
<body>
    <h4>직원 상세 정보</h4>
<%--    <h4>${name}</h4>--%>
    <table>
        <tr>
            <th>LastName</th>
            <th>FirstName</th>
            <th>BirthDate</th>
            <th>Photo</th>
            <th>Notes</th>
        </tr>
        <c:forEach items="${employees}" var="employ">
            <tr>
                <td> ${employ.lName}</td>
                <td>${employ.fName}</td>
                <td> ${employ.birth}</td>
                <td> ${employ.photo}</td>
                <td>${employ.note}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/api/ad">이전으로 가기</a>
    <button><a href=""></a>삭제하기</button>
</body>
</html>
