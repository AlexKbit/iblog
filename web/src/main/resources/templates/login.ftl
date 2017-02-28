<#import "single.ftl" as single>
<#import "/spring.ftl" as spring/>

<@single.page pageTitle="">
<div class="single-center">
    <form role="form" action="/login" method="post" class="form-signin">
        <div class="text-center">
            <h2 class="form-signin-heading"><@spring.message "messages.login"/></h2>
            <h6 class="form-signin-heading"><@spring.message "messages.login.help"/></h6>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <input type="email" class="form-control" name="email"
                   id="email" placeholder="<@spring.message "messages.login.label.login"/>"
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
        <br/>
        <button type="submit" class="btn btn-lg btn-primary btn-block"><@spring.message "messages.login.label.signin"/></button>
    </form>

    <#if error.isPresent()>
        <p><@spring.message "error.incorrect.password"/></p>
    </#if>
</div>
</@single.page>
