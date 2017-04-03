<#import "../layout.ftl" as layout>
<#import "../spring.ftl" as spring/>

<@layout.page pageTitle="">
<div class="panel panel-default row">
    <br/>
    <div class="col-lg-4">
        <label class="col-form-label">
            <@spring.message "messages.book.albumImage"/>
        </label>
        <#if book.imageId??>
            <img src="/image/${book.imageId}" class="image-book" border="1" onclick="$('#uploadingFile').click()">
        <#else>
            <img src="/images/noImage.png" class="image-book" border="1" onclick="$('#uploadingFile').click()">
        </#if>
        <form id="uploadingForm" name="uploadingForm" enctype="multipart/form-data" action="/admin/book/image" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input id="uploadingFile" type="file" name="uploadingFile"
                   class="hide-block" onchange="$('#uploadingForm').submit()">
        </form>
    </div>
    <div class="col-lg-6">
        <form action="/admin/book" role="form" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <#if book.imageId??>
                <input type="hidden" name="imageId" value="${book.imageId}"/>
            <#else>
                <input type="hidden" name="imageId" value=""/>
            </#if>
            <div class="form-group row">
                <label for="input-book-name" class="col-2 col-form-label">
                    <@spring.message "messages.book.name"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="name"
                           value="${book.name}" id="input-book-name">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-author" class="col-2 col-form-label">
                    <@spring.message "messages.book.author"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="author"
                           value="${book.author}" id="input-book-author">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-pageCount" class="col-2 col-form-label">
                    <@spring.message "messages.book.pageCount"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="number" name="pageCount"
                           value="${book.pageCount}" id="input-book-pageCount">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-currentPage" class="col-2 col-form-label">
                    <@spring.message "messages.book.currentPage"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="number" name="currentPage"
                           value="${book.currentPage}" id="input-book-currentPage">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-publishYear" class="col-2 col-form-label">
                    <@spring.message "messages.book.publishYear"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="number" name="publishYear"
                           value="${book.publishYear}" id="input-book-publishYear"">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-language" class="col-2 col-form-label">
                    <@spring.message "messages.book.language"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="text" name="language"
                           value="${book.language}" id="input-book-language">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-endDate" class="col-2 col-form-label">
                    <@spring.message "messages.book.endDate"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="date" name="endDate"
                           value="${book.endDate}" id="input-book-endDate">
                </div>
            </div>
            <div class="form-group row">
                <label for="input-book-rate" class="col-2 col-form-label">
                    <@spring.message "messages.book.rate"/>
                </label>
                <div class="col-10">
                    <input class="form-control" type="number" name="rate"
                           value="${book.rate}" id="input-book-rate" max="5" min="0" step="0.1">
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
