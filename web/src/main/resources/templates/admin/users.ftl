<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<h3>System Users</h3>

<table>
    <thead>
        <tr>
            <th>E-mail</th>
            <th>Role</th>
        </tr>
    </thead>
    <tbody>
        <#list users.content as user>
        <tr>
            <td>${user.email}</a></td>
            <td>${user.role}</td>
        </tr>
        </#list>
    </tbody>
</table>
</@layout.page>