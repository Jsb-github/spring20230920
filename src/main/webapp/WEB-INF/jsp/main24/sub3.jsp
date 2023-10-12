<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-10
  Time: 오후 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main24/sub2" method="post">
<%--  div*8>input[name] --%>
  <div>
    공급자 명
    <input type="text" name="suppliername">
  </div>
  <div>
    계약 명
    <input type="text" name="contactname">
  </div>
  <div>
    주소
    <input type="text" name="address">
  </div>
  <div>
    도시
    <input type="text" name="city">
  </div>
  <div>
    우편번호
    <input type="text" name="postalcode">
  </div>
  <div>
    국가
    <input type="text" name="country">
  </div>
  <div>
    전화번호
    <input type="text" name="phone">
  </div>
  <div><input type="submit" value="등록"></div>
</form>
</body>
</html>
