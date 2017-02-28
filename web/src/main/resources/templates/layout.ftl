<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<#import "/spring.ftl" as spring/>

<#macro page pageTitle>
    <!DOCTYPE html>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8"/>
        <title>My blog</title>
        <link rel="shortcut icon" href="/images/blog.ico"/>
        <link rel="stylesheet"  type="text/css" href="/css/bootstrap.min.css" />
        <link rel="stylesheet"  type="text/css" href="/css/jumbotron-narrow.css" />
        <link rel="stylesheet"  type="text/css" href="/css/style.css" />
        <script src="/js/jquery-3.1.1.min.js"></script>
        <script src="/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="container">
        <#include "header.ftl">
        <#nested/>
        <#include "footer.ftl">
    </div>
    </body>
    </html>
</#macro>