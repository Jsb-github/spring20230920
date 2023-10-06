<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-06
  Time: 오후 2:28
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

        .active{
            background-color: darkblue;
            color: #eeeeee;
        }
    </style>
</head>
<body>
    <h4>고객 목록</h4>
    <table>
        <tr>
            <th>번호</th>
            <th>이름</th>
        </tr>

        <c:forEach items="${customersList}" var="customers">
            <tr>
                <td>${customers.id}</td>
                <td>${customers.name}</td>
            </tr>
        </c:forEach>
    </table>

    <div>
        <a href="/main22/sub3?p=1">맨처음</a>
        <c:if  test="${prevPageNumber >0 }">
            <a href="/main22/sub3?p=${prevPageNumber}">이전</a>
        </c:if>

        <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="pageNumber">
            <a
                    <c:if test="${pageNumber == currentPage}">
                            class="active"
                    </c:if>
                    href="/main22/sub3?p=${pageNumber}">${pageNumber}
            |</a>
        </c:forEach>
        <c:if test="${lastPageNumber >= nextPageNumber}">
            <a href="/main22/sub3?p=${nextPageNumber}">다음</a>
        </c:if>
        <a href="/main22/sub3?p=${lastPageNumber}">마지막</a>
    </div>



</body>
</html>
