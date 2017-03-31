<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div>
    <div>
        <#if book?? && book.image??>
            <img src="/image/${book.image.id}" class="image-book" onclick="$('#uploadingFile').click()">
        <#else>
            <img src="/images/noImage.png" class="image-book" onclick="$('#uploadingFile').click()">
        </#if>
    </div>
    <form id="uploadingForm" name="uploadingForm" enctype="multipart/form-data" action="/admin/book/image" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input id="uploadingFile" type="file" name="uploadingFiles"
               class="hide-block" onchange="$('#uploadingForm').submit()">
    </form>
</div>
</@layout.page>
