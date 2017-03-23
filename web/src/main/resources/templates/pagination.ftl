<#import "/spring.ftl" as spring/>

<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<body>
    <div class="text-center">
        <ul class="pagination">
            <li class="${page.first?string('disabled', '')}">
            <#if !page.first>
                <a href="?page=0&count=${page.size}">
                    &laquo;
                </a>
            <#else>
                <a href="#">
                    &laquo;
                </a>
            </#if>
            </li>
        <#if !page.first>
            <li><a href="?page=${page.number-1}&count=${page.size}">${page.number}</a></li>
        </#if>
            <li class="active"><a href="#">${page.number+1}</a></li>
        <#if !page.last>
            <li><a href="?page=${page.number+1}&count=${page.size}">${page.number+2}</a></li>
        </#if>
            <li class="${page.last?string('disabled', '')}">
            <#if !page.last>
                <a href="?page=${page.totalPages-1}&count=${page.size}">
                    &raquo;
                </a>
            <#else>
                <a href="#">
                    &raquo;
                </a>
            </#if>
            </li>
        </ul>
    </div>
</body>
</html>