<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-11
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <div>
        제목 : <input type="text"name="title">
    </div>
    <div>
        내용 : <textarea name="content" id="" cols="30" rows="10"></textarea>
    </div>
    <div>
        작성자 : <input type="text" name="writer">
    </div>
    <div><button>등록</button></div>
</form>
</body>
</html>
