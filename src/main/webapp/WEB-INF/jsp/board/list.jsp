<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-11
  Time: 오후 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <STYLE>
        table{
            border-collapse: collapse;
            width: 100%;
            text-align: center;
        }
        th{
            background-color: chartreuse;
        }
        table,th,td{
            border: 1px solid black;
        }
    </STYLE>
</head>
<body>
    <table>
        <tr>
            <th>게시물 번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>이름</th>
            <th>작성일자</th>
        </tr>
        <c:forEach items="${myBoard}" var="myBoard">
            <tr>
                <td>${myBoard.no}</td>
                <td>${myBoard.title}</td>
                <td>${myBoard.content}</td>
                <td>${myBoard.writer}</td>
                <td>${myBoard.date}</td>
            </tr>
        </c:forEach>
    </table>
    <div><a href="/board/write">글쓰기</a></div>
</body>
</html>
