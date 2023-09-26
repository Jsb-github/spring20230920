<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-09-26
  Time: 오후 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/main14/sub4" method="post">
    <div>
        <label for="input1">제목</label>
        <input type="text" name="title" id="input1">
    </div>

    <div>
        <label for="textarea1">본문</label>
        <textarea name="content" id="textarea1" cols="30" rows="10"></textarea>
    </div>
    <button>전송</button>
</form>

</body>
</html>
