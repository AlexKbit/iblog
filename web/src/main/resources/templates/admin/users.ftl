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
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</@layout.page>