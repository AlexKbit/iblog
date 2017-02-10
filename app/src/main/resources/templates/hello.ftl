<@page />

<#macro page>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello</title>
    <link rel="stylesheet"  type="text/css" href="/static/css/bootstrap.min.css" />
    <link rel="stylesheet"  type="text/css" href="/static/css/jumbotron-narrow.css" />
</head>
<body>
<div class="container">
    <div class="header">
        <#include "header.ftl">
    </div>
    <p th:text="'Hello ' + ${name} + '!'" />
    <div class="footer">
        <#include "footer.ftl">
    </div>
</div>
</body>
</html>
</#macro>