<#import "layout.ftl" as layout>
<#import "/spring.ftl" as spring/>

<@layout.page pageTitle="">
<p><@spring.message "messages.welcome"/></p>
<p>Click <a href="/hi">here</a> to see a greeting.</p>
</@layout.page>
