<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div>
    <div class="text-center">
        <h3>System Users</h3>
    </div>

    <div class="table-hover">
        <table class="table">
            <thead>
                <tr>
                    <th>Login</th>
                    <th>E-mail</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Role</th>
                    <th>Enabled</th>
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
                    <td>${user.enabled?string('Enabled', 'Disabled')}</td>
                    <td>
                        <form action="/admin/users" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="hidden" name="page" value="${page.number}"/>
                            <input type="hidden" name="count" value="${page.size}"/>
                            <input type="hidden" name="userId" value="${user.id}"/>
                            <input type="hidden" name="enable" value="${user.enabled?string('false','true')}"/>
                            <button type="submit" class="btn btn-primary">
                                ${user.enabled?string('Disable','Enable')}
                            </button>
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