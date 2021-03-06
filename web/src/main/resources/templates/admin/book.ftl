<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div class="panel panel-default">
    <div class="panel-body">
    <br/>
    <div class="col-lg-4">
        <label class="col-form-label">
            <@spring.message "messages.book.albumImage"/>
        </label>
        <#if book.imageId??>
            <img id="imageBlock" src="/image/${book.imageId}" class="image-book" border="1" onclick="$('#uploadingFile').click()">
        <#else>
            <img id="imageBlock" src="/images/noImage.png" class="image-book" border="1" onclick="$('#uploadingFile').click()">
        </#if>
        <form id="uploadingForm" name="uploadingForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input id="uploadingFile" type="file" name="uploadingFile"
                   class="hide-block" onchange="uploadImage($('#uploadingFile'), $('#imageId'), $('#imageBlock'), '${_csrf.parameterName}', '${_csrf.token}')">
        </form>
    </div>
    <div class="col-lg-6">
        <form action="/admin/book" role="form" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <#if book.id??>
                <input type="hidden" name="id" value="${book.id}"/>
            </#if>
            <#if book.imageId??>
                <input type="hidden" name="imageId" id="imageId" value="${book.imageId}"/>
            <#else>
                <input type="hidden" name="imageId" id="imageId" value=""/>
            </#if>
            <div class="form-group row">
                <label for="input-book-name" class="col-2 col-form-label">
                    <@spring.message "messages.book.name"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="name"
                           value="${book.name}" id="input-book-name"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-author" class="col-2 col-form-label">
                    <@spring.message "messages.book.author"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="author"
                           value="${book.author}" id="input-book-author"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-pageCount" class="col-2 col-form-label">
                    <@spring.message "messages.book.pageCount"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="number" name="pageCount"
                           min="1" max="9999" step="1"
                           value="${book.pageCount}" id="input-book-pageCount"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-currentPage" class="col-2 col-form-label">
                    <@spring.message "messages.book.currentPage"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="number" name="currentPage"
                           min="0" max="9999" step="1"
                           value="${book.currentPage}" id="input-book-currentPage"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-publishYear" class="col-2 col-form-label">
                    <@spring.message "messages.book.publishYear"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="number" name="publishYear"
                           min="1900" max="9999" step="1"
                           value="${book.publishYear}" id="input-book-publishYear"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-language" class="col-2 col-form-label">
                    <@spring.message "messages.book.language"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="language"
                           value="${book.language}" id="input-book-language"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-endDate" class="col-2 col-form-label">
                    <@spring.message "messages.book.endDate"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="date" name="endDate"
                           value="${book.endDate}" id="input-book-endDate"
                           required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-rate" class="col-2 col-form-label">
                    <@spring.message "messages.book.rate"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="number" name="rate"
                           value="${book.rate}" id="input-book-rate" max="5" min="0" step="0.1"
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
</div>
</@layout.page>
