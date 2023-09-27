<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-09-27
  Time: 오전 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>선택한 음식들.</h3>
    <ul>
        <c:forEach items="${foods}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ul>
    <a href="/main15/sub9">다른페이지</a>
</body>
</html>
