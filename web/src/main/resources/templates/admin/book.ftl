<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div>
    <form name="uploadingForm" enctype="multipart/form-data" action="/admin/book/image" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p>
            <input id="fileInput" type="file" name="uploadingFiles">
        </p>
        <p>
            <input type="submit" value="Upload files">
        </p>
    </form>
</div>
</@layout.page>
