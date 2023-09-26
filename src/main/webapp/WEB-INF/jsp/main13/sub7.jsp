<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-09-26
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub8">
    <%--    div*7>label[for=input$]+input#input$[name][type]--%>
        <div>
            <label for="input1">아이디</label>
            <input type="number" id="input1" name="id">
        </div>
        <div>
            <label for="input2">이름</label>
            <input type="text" id="input2" name="name">
        </div>
        <div>
            <label for="input3">주소</label>
            <input type="text" id="input3" name="address">
        </div>
        <div>
            <label for="input4">스케쥴</label>
            <input type="datetime-local" id="input4" name="schedule">
        </div>
        <h3>할일</h3>
        <div>
            <label for="input5">공부하기</label>
            <input type="checkbox" id="input5" name="todos" value="study">
        </div>
        <div>
            <label for="input5">운동하기</label>
            <input type="checkbox" id="input6" name="todos" value="exercise">
        </div>
        <div>
            <label for="input5">빨래하기</label>
            <input type="checkbox" id="input7" name="todos" value="Wash">
        </div>
        <button>전송</button>
</form>
</body>
</html>
