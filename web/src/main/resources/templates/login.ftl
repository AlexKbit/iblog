<#import "single.ftl" as single>
<#import "/spring.ftl" as spring/>

<@single.page pageTitle="">
<div class="single-center">
    <div class="text-center">
        <h2 class="form-signin-heading"><@spring.message "messages.login"/></h2>
        <h6 class="form-signin-heading"><@spring.message "messages.login.help"/></h6>
    </div>
    <#if error.isPresent()>
        <div class="alert alert-danger" role="alert">
            <p><@spring.message "error.incorrect.password"/></p>
        </div>
    </#if>
    <form role="form" action="/login" method="post" class="form-signin">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <input type="email" class="form-control" name="email"
                   id="email" placeholder="<@spring.message "messages.login.label.email"/>"
                   required autofocus>
        </div>
        <div>
            <input type="password" class="form-control" name="password"
                   id="password" placeholder="<@spring.message "messages.login.label.password"/>"
                   required>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="remember-me" id="remember-me">
                <@spring.message "messages.login.label.remember"/>
            </label>
        </div>
        <#--<br/>-->
        <button type="submit" class="btn btn-lg btn-primary btn-block"><@spring.message "messages.login.label.signin"/></button>
    </form>
    <div class="text-center">
        <p>
            <a href="/register/new"><@spring.message "messages.login.label.newAccount"/></a>
            <a href="/"><@spring.message "messages.login.label.getBack"/></a>
        </p>
    </div>
</div>
</@single.page>
