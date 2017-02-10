<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Home</title>
    <link rel="stylesheet"  type="text/css" href="/static/css/bootstrap.min.css" />
    <link rel="stylesheet"  type="text/css" href="/static/css/jumbotron-narrow.css" />
</head>
<body>
<div class="container">
    <div class="header">
        <#include "header.ftl">
    </div>
    <h1>Welcome!</h1>
    <p>Click <a th:href="@{/hi}">here</a> to see a greeting.</p>
    <div class="footer">
        <#include "footer.ftl">
    </div>
</div>
</body>
</html>