<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div>
    <div class="text-center">
        <h3><@spring.message "messages.admin.tags.title"/></h3>
    </div>

    <div class="table-hover">
        <table class="table">
            <thead>
                <tr>
                    <th><@spring.message "messages.admin.tags.table.logo"/></th>
                    <th><@spring.message "messages.admin.tags.table.name"/></th>
                    <th><@spring.message "messages.admin.tags.table.description"/></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <#list page.content as tag>
                <tr>
                    <td>
                        <#if tag.imageId??>
                            <img src="/image/${tag.imageId}" class="image-tag" border="1">
                        <#else>
                            <img src="/images/noImage.png" class="image-tag" border="1">
                        </#if>
                    </td>
                    <td>${tag.name}</td>
                    <td>${tag.description}</td>
                    <td>
                        <a href="/tag/${tag.id}" class="btn btn-primary">
                            <@spring.message "messages.edit"/>
                        </a>
                    </td>
                    <td></td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#include "../pagination.ftl">
    </div>
</div>
</@layout.page>