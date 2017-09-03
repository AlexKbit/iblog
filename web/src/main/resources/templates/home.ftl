<#import "layout.ftl" as layout>
<#import "/spring.ftl" as spring/>

<@layout.page pageTitle="">
<img src="/images/homeHead.png"/>
<br/>
<p><@spring.message "messages.welcome"/></p>
<br/>
<p><@spring.message "messages.siteinfo"/></p>
</@layout.page>
