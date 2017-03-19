<#import "single.ftl" as single>
<#import "/spring.ftl" as spring/>

<@single.page pageTitle="">
<div class="single-center">
    <#--<@spring.bind "form" />-->
    <#--<#if spring.status.error>
        <div class="alert alert-danger" role="alert">
        <ul>
            <#list spring.status.errorMessages as error>
                <li>${error}</li>
            </#list>
        </ul>
        </div>
    </#if>-->
    <div class="text-center">
        <h2 class="form-signin-heading"><@spring.message "messages.register"/></h2>
    </div>
    <form role="form" action="/register/new" method="post" class="form-signin">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <input type="text" class="form-control" name="login"
                   id="login" placeholder="<@spring.message "messages.register.label.login"/>"
                   required>
        </div>
        <div>
            <input type="email" class="form-control" name="email"
                   id="email" placeholder="<@spring.message "messages.register.label.email"/>"
                   required>
        </div>
        <div>
            <input type="text" class="form-control" name="name"
                   id="name" placeholder="<@spring.message "messages.register.label.name"/>"
                   required>
        </div>
        <div>
            <input type="text" class="form-control" name="surname"
                   id="surname" placeholder="<@spring.message "messages.register.label.surname"/>">
        </div>
        <div>
            <input type="password" class="form-control" name="password"
                   id="password" placeholder="<@spring.message "messages.register.label.password"/>"
                   required>
        </div>
        <div>
            <input type="password" class="form-control" name="confirmPassword"
                   id="password" placeholder="<@spring.message "messages.register.label.confirmPassword"/>"
                   required>
        </div>
        <br/>
        <button type="submit" class="btn btn-lg btn-primary btn-block">
            <@spring.message "messages.register.label.register"/>
        </button>
    </form>
        <div class="text-center">
            <p>
                <a href="/"><@spring.message "messages.login.label.getBack"/></a>
            </p>
        </div>
</div>
</@single.page>
