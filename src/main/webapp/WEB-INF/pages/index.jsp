<%--
  Created by IntelliJ IDEA.
  User: STARS
  Date: 2021/9/11
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">好友列表</div>
        <div class="panel-body">
            <div class="list-group" role="group" aria-label="好友列表">
                <button type="button" class="list-group-item" data-toggle="modal" data-target="#exampleModal"
                        data-whatever="张三">张三
                </button>
                <button type="button" class="list-group-item" data-toggle="modal" data-target="#exampleModal"
                        data-whatever="李四">李四
                </button>
                <button type="button" class="list-group-item" data-toggle="modal" data-target="#exampleModal"
                        data-whatever="王二">王二
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
