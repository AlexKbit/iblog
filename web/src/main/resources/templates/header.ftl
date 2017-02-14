<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<body>
<div id="page_header">
    <nav class="navbar navbar-default navbar-static-top">
        <a class="navbar-brand" href="/">
            <img src="images/blog.png" width="25px" height="25px"/>
        </a>
        <ul class="nav navbar-nav">
            <li><a href="/"><i class="fa fa-home"></i>Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <!--<div sec:authorize="isAuthenticated()">
                    <form th:action="@{/logout}" method="post">
                        <input type="submit" value="Sign Out" class="btn btn-default navbar-btn"/>
                    </form>
                </div>-->
            </li>
        </ul>
    </nav>
</div>
</body>
</html>