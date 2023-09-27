<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-09-27
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <div>
            <a href="/main17/list">목록보기</a>
        </div>
    </div>
    <div>
        ${message}
    </div>
    <h1>글보기</h1>
    <div>
        <label for="titleInput">제목</label>
        <input type="text" id="titleInput" name="title" value="${post.title}">
    </div>
    <div>
        <%--        textara[placeholder=본문][name=body]--%>
            <textarea name="body" id="" cols="30" rows="10">${post.body}</textarea>
    </div>
</body>
</html>
