<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-10
  Time: 오후 5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>새직원 추가</h4>
<form action="/api/add1" method="post">
    <%--    div*6>input[name]--%>
        <div>
            lastname
            <input type="text" name="lastName">
        </div>
        <div>
            firstname
            <input type="text" name="firstName">
        </div>
        <div>
            날짜
            <input type="date" name="birthDate" value="2002-02-02">
        </div>
        <div>
            사진
            <input type="text" name="photo">
        </div>
        <div>
        <textarea name="notes" id="" cols="30" rows="10">
        </textarea>
        </div>
        <div>
            <input type="submit"value="전송">
        </div>
</form>
<a href="/api/ad">이전으로 가기</a>
</body>
</html>
