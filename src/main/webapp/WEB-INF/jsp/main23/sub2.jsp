<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-10
  Time: 오전 9:48
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
            text-align: center;
            width: 100%;
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
<form action="">
    검색어
    <input type="text" name="k" placeholder="검색어 입력해주세요.">
    <button>검색</button>
</form>
<c:if  test="${keyWord !='' }">
    <h4>${keyWord}가 중간에 있는 고객명</h4>
</c:if>

<table>

    <tr>
        <th>고객명</th>
    </tr>
    <c:forEach items="${customerNameList}" var="customerName">
        <tr>
            <td>${customerName.name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
