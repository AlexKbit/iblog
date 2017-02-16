<#import "/spring.ftl" as spring/>

<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<body>
<div id="page_header">
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">
                    <img src="images/blog.png" width="25px" height="25px"/>
                </a>
            </div>

            <div class="collapse navbar-collapse" id="navbar-links">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/posts"><i class="fa fa-home"></i><@spring.message "messages.posts"/></a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li><a href="/aboutMe"><i class="fa fa-home"></i><@spring.message "messages.aboutMe"/></a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="?lang=en">
                            <img src="images/lang/en.png" width="20px" height="20px"/>
                        </a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="?lang=ru">
                            <img src="images/lang/ru.png" width="20px" height="20px"/>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
</body>
</html>