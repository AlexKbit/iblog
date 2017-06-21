<#import "layout.ftl" as layout>
<#import "/spring.ftl" as spring/>

<@layout.page pageTitle="">
<div class="panel panel-default">
    <div class="panel-body">
    <br/>
    <div class="col-lg-4">
        <#if user.avatarId??>
            <img id="imageBlock" src="/image/${user.avatarId}" class="image-avatar img-circle" onclick="$('#uploadingFile').click()">
        <#else>
            <img id="imageBlock" src="/images/person.png" class="image-avatar img-circle" onclick="$('#uploadingFile').click()">
        </#if>
        <form id="uploadingForm" name="uploadingForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input id="uploadingFile" type="file" name="uploadingFile"
                   class="hide-block" onchange="uploadImage($('#uploadingFile'), $('#imageId'), $('#imageBlock'), '${_csrf.parameterName}', '${_csrf.token}')">
        </form>
    </div>
    <div class="col-lg-6">
        <form action="/account/edit" role="form" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="${user.id}"/>
            <input type="hidden" name="email" value="${user.email}"/>
            <input type="hidden" name="login" value="${user.login}"/>
            <#if user.avatarId??>
                <input id="imageId" type="hidden" name="avatarId" value="${user.avatarId}"/>
            <#else>
                <input id="imageId" type="hidden" name="avatarId" value=""/>
            </#if>
            <div class="form-group row">
                <label class="col-md-3">
                    <@spring.message "messages.admin.users.table.login"/>:
                </label>
                <div class="col-md-6">
                    <samp>
                        ${user.login}
                    </samp>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3">
                    <@spring.message "messages.admin.users.table.email"/>:
                </label>
                <div class="col-md-6">
                    <samp>
                        ${user.email}
                    </samp>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 account-form-label">
                    <@spring.message "messages.admin.users.table.name"/>:
                </label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="name"
                           id="userName" value="${user.name}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 account-form-label">
                    <@spring.message "messages.admin.users.table.surname"/>:
                </label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="surname"
                           id="userSurName" value="${user.surname}" required>
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
</div>
</@layout.page>
