<#import "layout.ftl" as layout>
<#import "/spring.ftl" as spring/>

<@layout.page pageTitle="">
<div>
    <div class="text-center">
        <h3><@spring.message "messages.library"/></h3>
    </div>
    <div>
        <#list page.content as book>
            <div class="panel panel-default">
                <div class="panel-body">
                    <#if book.image?? && book.image.id??>
                        <img src="/image/${book.image.id}" class="image-book-small">
                    <#else>
                        <img src="/images/noImage.png" class="image-book-small">
                    </#if>
                </div>
            </div>
        </#list>
        <#include "pagination.ftl">
    </div>
</div>
</@layout.page>