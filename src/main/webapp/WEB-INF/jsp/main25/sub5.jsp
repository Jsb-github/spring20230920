<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-10-11
  Time: 오전 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>배송업체 정보 변경</h4>
<form action="" method="post">
    <div>
        번호
        <input type="number" name="id" value="${shipper.shipperId}">
    </div>
    <div>
        이름
        <input type="text" name="name" value="${shipper.shipperName}">
    </div>
    <div>
        전화번호
        <input type="text" name="phone" value="${shipper.phone}">
    </div>
    <div>
        <button>수정</button>
    </div>

</form>


</body>
</html>
