<#import "layout.ftl" as layout>
<#import "/spring.ftl" as spring/>

<@layout.page pageTitle="">
<div xmlns="http://www.w3.org/1999/html">
    <div class="text-center">
        <h3><@spring.message "messages.posts"/></h3>
    </div>
    <div>
        <#list page.content as post>
            <div class="panel panel-default">
                <div class="panel-body row">
                    <div class="col-md-3">
                        <#if post.imageId??>
                            <img src="/image/${post.imageId}" class="image-book-small">
                        <#else>
                            <img src="/images/noImage.png" class="image-book-small">
                        </#if>
                    </div>
                    <div class="col-md-9">
                        <div class="row">
                            <div class="col-md-2">
                                <label><@spring.message "messages.post.theme"/>:</label>
                            </div>
                            <div class="col-md-9">
                                <output class="output-info">${post.theme}</output>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
        <#include "pagination.ftl">
    </div>
</div>
</@layout.page>