<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div class="text-center">
    <h3><@spring.message "messages.admin.tag"/></h3>
</div>
<div class="panel panel-default">
    <div class="panel-body">
    <br/>
    <div class="col-lg-2">
        <#if tag.imageId??>
            <img id="imageBlock" src="/image/${book.imageId}" class="image-tag" border="1" onclick="$('#uploadingFile').click()">
        <#else>
            <img id="imageBlock" src="/images/noImage.png" class="image-tag" border="1" onclick="$('#uploadingFile').click()">
        </#if>
        <form id="uploadingForm" name="uploadingForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input id="uploadingFile" type="file" name="uploadingFile"
                   class="hide-block" onchange="uploadImage($('#uploadingFile'), $('#imageId'), $('#imageBlock'), '${_csrf.parameterName}', '${_csrf.token}')">
        </form>
    </div>
    <div class="col-lg-8">
        <form action="/admin/tag" role="form" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <#if tag.id??>
                <input type="hidden" name="id" value="${tag.id}"/>
            </#if>
            <#if tag.imageId??>
                <input type="hidden" name="imageId" id="imageId" value="${tag.imageId}"/>
            <#else>
                <input type="hidden" name="imageId" id="imageId" value=""/>
            </#if>
            <div class="form-group row">
                <label for="input-tag-name" class="col-2 col-form-label">
                    <@spring.message "messages.admin.tags.table.name"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="name"
                           value="${tag.name}" id="input-tag-name"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-tag-description" class="col-2 col-form-label">
                    <@spring.message "messages.admin.tags.table.description"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="author"
                           value="${tag.description}" id="input-tag-description"
                           required>
                </div>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">
                    <@spring.message "messages.save"/>
                </button>
                <a href="/admin/tags" class="btn btn-primary"><@spring.message "messages.back"/></a>
            </div>
        </form>
        <br/>
    </div>
    </div>
</div>
</@layout.page>
