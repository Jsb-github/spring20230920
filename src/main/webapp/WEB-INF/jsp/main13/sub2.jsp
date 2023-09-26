<%--
  Created by IntelliJ IDEA.
  User: tjdql
  Date: 2023-09-26
  Time: 오전 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub3">
<%--    div*10>label[for=input$]>lorem1^input[type][name][id=input$]--%>
    <div>
        <label for="input1">Lorem.</label>
        <input type="text" name="param1" id="input1">
        </div>
    <div>
        <label for="input2">Quaerat!</label>
        <input type="number" name="param2" id="input2">
    </div>
    <div>
        <label for="input3">Eveniet!</label>
        <input type="password" name="param3" id="input3">
    </div>
    <div>
        <label for="input4">Et!</label>
        <input type="date" name="param4" id="input4">
    </div>
    <div>
        <label for="input5">Temporibus.</label>
        <input type="datetime-local" name="param5" id="input5">
        </div>
    <div>
        <label for="input6">Debitis?</label>
        <input type="radio"value="radio value1" name="param6" id="input6">
    </div>
    <div>
        <label for="input7">Laboriosam.</label>
        <input type="radio" value="radio value2" name="param7" id="input7">
    </div>
    <div>
        <label for="input8">Hic?</label>
        <input type="checkbox" name="param8" value="pizza" id="input8">
    </div>
    <div>
        <label for="input9">Soluta?</label>
        <input type="checkbox" name="param8" value="melon" id="input9">
    </div>
    <div>
        <label for="input10">Saepe?</label>
        <input type="checkbox" name="param8" value="coffee" id="input10">
    </div>
    <button>전송</button>
</form>
</body>
</html>
