<#import "single.ftl" as single>
<#import "/spring.ftl" as spring/>

<@single.page pageTitle="">
<div style="padding-left: 25%; padding-right: 25%">
    <form role="form" action="/login" method="post" class="form-signin">
        <div class="text-center">
            <h2 class="form-signin-heading"><@spring.message "messages.login"/></h2>
            <h6 class="form-signin-heading"><@spring.message "messages.login.help"/></h6>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="email" class="sr-only">Email address</label>
            <input type="email" class="form-control" name="email" id="email" required autofocus>
        </div>
        <div>
            <label for="password" class="sr-only">Password</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>
        <div class="checkbox">
            <label for="remember-me">Remember me</label>
            <input type="checkbox" name="remember-me" id="remember-me">
        </div>
        <button type="submit" class="btn btn-lg btn-primary btn-block">Sign in</button>
    </form>

    <#if error.isPresent()>
        <p><@spring.message "error.incorrect.password"/></p>
    </#if>
</div>
</@single.page>
