<%--
  Created by IntelliJ IDEA.
  User: STARS
  Date: 2021/9/10
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Daybook</title>
  <link type="text/css" href="${pageContext.request.contextPath}/static/css/mybook.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/static/js/mybook.js" rel="script" type="text/javascript"></script>
</head>
<body>
<div>
</div>
<div id="contain">
  <br/><br/><br/><br/><br/>
  <label class="logic">登录窗口</label>
  <br/><br/><br/><br/><br/>
  <form action="${pageContext.request.contextPath}/user/login" method="post">
    <input class="userid" type="text" name="id" placeholder="账户">
    <br/><br/><br/>
    <input class="userPassword" type="password" name="password" placeholder="密码">
    <br/><br/><br/>
    <a href="${pageContext.request.contextPath}/user/toregister">忘记密码?</a>
    <strong>||</strong>
    <a onclick="select_sing()">Sing Up</a>
    <br/><br/><br/>
    <input class="login" type="submit" value="登 录">
  </form>
  <form style="display: none">
    <label>
      <input class="combo" type="text" list="id">
      <datalist id="id">
        <option value="ACm"></option>
        <option value="试试"></option>
      </datalist>
    </label>
  </form>
</div>

<div id="contain-off">
  <br/><br/><br/><br/><br/>
  <label class="logic">注册窗口</label>
  <br/><br/><br/><br/><br/>
  <form action="${pageContext.request.contextPath}/user/register" method="post">
    <input class="userid" type="text" name="id" placeholder="账户">
    <br/><br/><br/>
    <input class="userPassword" type="password" name="password" placeholder="密码">
    <br/><br/><br/>
    <a href="${pageContext.request.contextPath}/user/toregister">忘记密码?</a>
    <strong>||</strong>
    <a onclick="select_sing()">Sing Up</a>
    <br/><br/><br/>
    <input class="login" type="submit" value="登 录">
  </form>
</div>
</body>
</html>
