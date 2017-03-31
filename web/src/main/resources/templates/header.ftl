<#import "/spring.ftl" as spring/>

<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<body>
<div id="page_header">
    <nav id="appTab" class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">
                    <img src="/images/blog.png" class="nb-image-small"/>
                </a>
            </div>

            <div class="collapse navbar-collapse" id="navbar-links">
                <ul class="nav navbar-nav">
                    <li><a href="/posts"><i class="fa fa-home"></i><@spring.message "messages.posts"/></a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li><a href="/library"><i class="fa fa-home"></i><@spring.message "messages.library"/></a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li><a href="/aboutMe"><i class="fa fa-home"></i><@spring.message "messages.aboutMe"/></a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a id="lang-dropdown" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <@spring.message "messages.language"/> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="?lang=en">
                                    <img src="/images/lang/en.png" class="nb-image-small"/>
                                    <@spring.message "messages.language.en"/>
                                </a>
                            </li>
                            <li>
                                <a href="?lang=ru">
                                    <img src="/images/lang/ru.png" class="nb-image-small"/>
                                    <@spring.message "messages.language.ru"/>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <#if !currentUser??>
                        <li class="nb-li">
                            <a href="/login" class="nb-link">
                                <img src="/images/menu/login.png" width="25px" height="25px" title="<@spring.message "messages.login"/>"/>
                            </a>
                        </li>
                    </#if>
                    <#if currentUser??>
                        <li class="dropdown nb-li">
                            <a id="user-dropdown" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <img src="/images/menu/menu.png" class="nb-image-small"/></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="/profile">
                                        <img src="/images/menu/account.png" class="nb-image-small"/>
                                        <@spring.message "messages.menu.account"/>
                                    </a>
                                </li>
                                <#if currentUser.role == "ADMIN">
                                    <li>
                                        <a href="/admin/users">
                                            <img src="/images/menu/users.png" class="nb-image-small"/>
                                            <@spring.message "messages.menu.users"/>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/admin/book">
                                            <img src="/images/menu/newBook.png" class="nb-image-small"/>
                                            <@spring.message "messages.menu.newBook"/>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/posts/new">
                                            <img src="/images/menu/newPost.png" class="nb-image-small"/>
                                            <@spring.message "messages.menu.newPost"/>
                                        </a>
                                    </li>
                                </#if>
                                <li class="divider"></li>
                                <li>
                                    <a onclick="document.getElementById('logout_form').submit()" class="clickable-link">
                                        <form id="logout_form" action="/logout" method="post">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        </form>
                                        <img src="/images/menu/logout.png" class="nb-image-small"/>
                                        <@spring.message "messages.menu.logout"/>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</div>
</body>
</html>