<#import "single.ftl" as single>
<#import "/spring.ftl" as spring/>

<@single.page pageTitle="">
<div class="single-center">
    <div class="text-center">
        <h2 class="form-signin-heading"><@spring.message "error.label"/></h2>
        <br/>
        <#if msg??>
            ${msg}
        </#if>
        <br/>
        <a href="/" class="btn btn-lg btn-primary btn-block">
            <@spring.message "messages.back"/>
        </a>
    </div>
</div>
</@single.page>
