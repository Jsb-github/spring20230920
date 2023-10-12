<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-10
  Time: 오전 11:14
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
    <h4>직원 조회</h4>
    <form action="">
        <div>
            검색 조건
            <select name="t" id="">
            <option value="lname" ${searchType=='lname' ? 'selected' :'' }>Last Name</option>
            <option value="fname" ${searchType=='fname' ? 'selected' :'' }>First Name</option>
            <option value="note" ${searchType=='note' ? 'selected' :'' }>Notes</option>
        </select>
        </div>
        <div>
            검색어
            <input type="text" name="k" value="${keyword}">
        </div>
        <div>
            <button>조회</button>
        </div>
    </form>

    <table>
        <tr>
            <c:if test="${searchType=='lname'}"><th>lastName</th></c:if>
            <c:if test="${searchType=='fname'}"><th>firstName</th> </c:if>
            <c:if test="${searchType=='note'}"><th>note</th></c:if>
        </tr>
        <c:forEach items="${employeesList}" var="employees">
            <tr>
                <c:if test="${searchType=='lname'}"> <td>${employees.lastName}</td></c:if>
                <c:if test="${searchType=='fname'}"> <td>${employees.firstName}</td></c:if>
                <c:if test="${searchType=='note'}"><td>${employees.note}</td></c:if>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
