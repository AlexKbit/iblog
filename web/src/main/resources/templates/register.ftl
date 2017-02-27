<#import "single.ftl" as single>
<#import "/spring.ftl" as spring/>

<@single.page pageTitle="">
<div style="padding-left: 25%; padding-right: 25%">
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
    <form role="form" action="/register/new" method="post" class="form-signin">
        <div class="text-center">
            <h2 class="form-signin-heading"><@spring.message "messages.register"/></h2>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="login" class="sr-only">Login</label>
            <input type="text" class="form-control" name="login" id="login" required>
        </div>
        <div>
            <label for="email" class="sr-only">Email address</label>
            <input type="email" class="form-control" name="email" id="email" required>
        </div>
        <div>
            <label for="password" class="sr-only">Password</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>
        <div>
            <label for="name" class="sr-only">Name</label>
            <input type="text" class="form-control" name="name" id="name" required>
        </div>
        <div>
            <label for="surname" class="sr-only">Surname</label>
            <input type="text" class="form-control" name="surname" id="surname" required>
        </div>
        <button type="submit" class="btn btn-lg btn-primary btn-block">Registration</button>
    </form>
</div>
</@single.page>
