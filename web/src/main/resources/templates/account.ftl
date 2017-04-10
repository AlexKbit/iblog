<#import "layout.ftl" as layout>
<#import "/spring.ftl" as spring/>

<@layout.page pageTitle="">
<div class="panel panel-default row">
    <br/>
    <div class="col-lg-4">
        <#if user.avatarId??>
            <img src="/image/${user.avatarId}" class="image-avatar img-circle" onclick="$('#uploadingFile').click()">
        <#else>
            <img src="/images/person.png" class="image-avatar img-circle" onclick="$('#uploadingFile').click()">
        </#if>
        <form id="uploadingForm" name="uploadingForm" enctype="multipart/form-data" action="/account/avatar" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input id="uploadingFile" type="file" name="uploadingFile"
                   class="hide-block" onchange="$('#uploadingForm').submit()">
        </form>
    </div>
    <div class="col-lg-6">
        <form action="/account" role="form" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="${user.id}"/>
            <#if user.avatarId??>
                <input type="hidden" name="avatarId" value="${user.avatarId}"/>
            <#else>
                <input type="hidden" name="avatarId" value=""/>
            </#if>
            <div class="form-group row">
                <label for="input-book-name" class="col-2 col-form-label">
                    <@spring.message "messages.admin.users.table.login"/>
                </label>
                <div class="col-10">
                    <output class="form-control" type="text" value="${user.login}">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-name" class="col-2 col-form-label">
                    <@spring.message "messages.admin.users.table.email"/>
                </label>
                <div class="col-10">
                    <output class="form-control" type="text" value="${user.email}">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-name" class="col-2 col-form-label">
                    <@spring.message "messages.admin.users.table.name"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="name"
                           value="${user.name}" id="input-user-name"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-author" class="col-2 col-form-label">
                    <@spring.message "messages.book.author"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="surname"
                           value="${user.surname}" id="input-user-surname"
                           required>
                </div>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">
                    <@spring.message "messages.save"/>
                </button>
                <a href="/" class="btn btn-primary"><@spring.message "messages.back"/></a>
            </div>
        </form>
        <br/>
    </div>
</div>
</@layout.page>
