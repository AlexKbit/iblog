<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div>
    <div class="text-center">
        <h3><@spring.message "messages.admin.users.title"/></h3>
    </div>

    <div class="table-hover">
        <table class="table">
            <thead>
                <tr>
                    <th><@spring.message "messages.admin.users.table.login"/></th>
                    <th><@spring.message "messages.admin.users.table.email"/></th>
                    <th><@spring.message "messages.admin.users.table.name"/></th>
                    <th><@spring.message "messages.admin.users.table.surname"/></th>
                    <th><@spring.message "messages.admin.users.table.role"/></th>
                    <th><@spring.message "messages.admin.users.table.enabled"/></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <#list page.content as user>
                <tr>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.role}</td>
                    <#if user.enabled>
                        <td><@spring.message "messages.admin.users.enable"/></td>
                    <#else>
                        <td><@spring.message "messages.admin.users.disable"/></td>
                    </#if>
                    <td>
                        <form action="/admin/users" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="hidden" name="page" value="${page.number}"/>
                            <input type="hidden" name="count" value="${page.size}"/>
                            <input type="hidden" name="userId" value="${user.id}"/>
                            <input type="hidden" name="enable" value="${user.enabled?string('false','true')}"/>
                            <button type="submit" class="btn btn-primary">
                                <#if user.enabled>
                                    <@spring.message "messages.admin.users.disable"/>
                                <#else>
                                    <@spring.message "messages.admin.users.enable"/>
                                </#if>
                            </button>
                        </form>
                    </td>
                    <td>
                        <a href="/account/${user.id}" class="btn btn-primary">
                            <@spring.message "messages.edit"/>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#include "../pagination.ftl">
    </div>
</div>
</@layout.page>