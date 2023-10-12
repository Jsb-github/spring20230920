<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-10
  Time: 오후 4:54
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

        .active{
            background-color: darkblue;
            color: #eeeeee;
        }
    </style>
</head>
<body>
<h3>직원명부</h3>
    <table>
        <tr>
            <th>이름</th>
            <th>직원 생일</th>
            <th>사진</th>
        </tr>
        <c:forEach items="${employees}" var="employ">
            <tr>
                <td><a href="/api/list?p=${employ.name}">${employ.name}</a></td>
                <td>${employ.birth}</td>
                <td>${employ.photo}</td>
            </tr>
        </c:forEach>
    </table>
<div>
    <a href="/api/ad?p=1">맨처음</a>
    <c:if  test="${prevPageNumber >0 }">
        <a href="/api/ad?p=${prevPageNumber}">이전</a>
    </c:if>

    <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="pageNumber">
        <a
                <c:if test="${pageNumber == currentPage}">
                    class="active"
                </c:if>
                href="/api/ad?p=${pageNumber}">${pageNumber}
            |</a>
    </c:forEach>
    <c:if test="${lastPageNumber >= nextPageNumber}">
        <a href="/api/ad?p=${nextPageNumber}">다음</a>
    </c:if>
    <a href="/api/ad?p=${lastPageNumber}">마지막</a>
</div>
    <div><buutton><a href="/api/add1">직원 추가</a></buutton></div>

</body>
</html>
