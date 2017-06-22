<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div>
    <div class="text-center">
        <h3><@spring.message "messages.admin.tags.title"/></h3>
    </div>
    <div class="input-group">
        <input id="searchText" type="text" class="form-control" value="${page.search}">
        <span class="input-group-btn">
            <button class="btn btn-default" type="button" onclick="searhResult('?page=${page.number}&count=${page.size}','searchText')">
                <@spring.message "messages.search"/>
            </button>
        </span>
    </div>

    <div class="table-hover">
        <table class="table table-vertical-middle">
            <thead>
                <tr>
                    <th><@spring.message "messages.admin.tags.table.logo"/></th>
                    <th><@spring.message "messages.admin.tags.table.name"/></th>
                    <th><@spring.message "messages.admin.tags.table.description"/></th>
                    <th>
                        <a href="/admin/tag">
                            <img src="/images/newTag.png" class="nb-image-small"/>
                        </a>
                    </th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <#list page.content as tag>
                <tr>
                    <td class="vertical-align-middle">
                        <#if tag.imageId??>
                            <img src="/image/${tag.imageId}" class="image-tag" border="1">
                        <#else>
                            <img src="/images/noImage.png" class="image-tag" border="1">
                        </#if>
                    </td>
                    <td class="vertical-align-middle">
                        ${tag.name}
                    </td>
                    <td class="vertical-align-middle">
                        ${tag.description}
                    </td>
                    <td class="vertical-align-middle">
                        <a href="/admin/tag/${tag.id}" class="btn btn-primary">
                            <@spring.message "messages.edit"/>
                        </a>
                    </td>
                    <td class="vertical-align-middle">
                        <form id="delete${tag.id}"
                              action="/admin/tag/delete/${tag.id}" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <a class="btn btn-primary" onclick="$('#delete${tag.id}').submit()">
                                <@spring.message "messages.delete"/>
                            </a>
                        </form>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#include "../pagination.ftl">
    </div>
</div>
</@layout.page>