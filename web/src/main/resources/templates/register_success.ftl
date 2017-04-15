<#import "single.ftl" as single>
<#import "/spring.ftl" as spring/>

<@single.page pageTitle="">
<div class="single-center">
    <div class="text-center">
        <h2 class="form-signin-heading"><@spring.message "messages.register.success"/></h2>
        <br/>
        <a href="/login" class="btn btn-lg btn-primary btn-block">
            <@spring.message "messages.login"/>
        </a>
    </div>
</div>
</@single.page>
