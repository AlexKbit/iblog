<#import "layout.ftl" as layout>
<#import "/spring.ftl" as spring/>

<@layout.page pageTitle="">
<div xmlns="http://www.w3.org/1999/html">
    <div class="text-center">
        <h3><@spring.message "messages.library"/></h3>
    </div>
    <div>
        <#list page.content as book>
            <div class="panel panel-default">
                <div class="panel-body row">
                    <div class="col-md-3">
                        <#if book.imageId??>
                            <img src="/image/${book.imageId}" class="image-book-small">
                        <#else>
                            <img src="/images/noImage.png" class="image-book-small">
                        </#if>
                        <#if currentUser?? && currentUser.role == "ADMIN">
                        <div>
                            <a href="/admin/book/${book.id}" class="btn" style="float: left">
                                <@spring.message "messages.edit"/>
                            </a>
                            <form action="/admin/book/${book.id}" method="delete">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <a class="btn" type="submit">
                                    <@spring.message "messages.delete"/>
                                </a>
                            </form>
                        </div>
                        </#if>
                    </div>
                    <div class="col-md-9">
                        <div class="row">
                            <div class="col-md-2">
                                <label><@spring.message "messages.book.name"/>:</label>
                            </div>
                            <div class="col-md-4">
                                <output class="output-info">${book.name}</output>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2">
                                <label><@spring.message "messages.book.author"/>:</label>
                            </div>
                            <div class="col-md-4">
                                <output class="output-info">${book.author}</output>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label><@spring.message "messages.book.pageCount"/>:</label>
                            </div>
                            <div class="col-md-2">
                                <output class="output-info">${book.pageCount}</output>
                            </div>
                            <div class="col-md-4">
                                <label><@spring.message "messages.book.publishYear"/>:</label>
                            </div>
                            <div class="col-md-1">
                                <output class="output-info">${book.publishYear}</output>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label><@spring.message "messages.book.currentPage"/>:</label>
                            </div>
                            <div class="col-md-2">
                                <output class="output-info">${book.currentPage}</output>
                            </div>
                            <div class="col-md-3">
                                <label><@spring.message "messages.book.endDate"/>:</label>
                            </div>
                            <div class="col-md-3">
                                <output class="output-info">${book.endDate}</output>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label><@spring.message "messages.book.language"/>:</label>
                            </div>
                            <div class="col-md-2">
                                <output class="output-info">${book.language}</output>
                            </div>
                            <div class="col-md-1">
                                <label><@spring.message "messages.book.rate"/>:</label>
                            </div>
                            <div class="col-md-2">
                                <output class="output-info">${book.rate}</output>
                            </div>
                        </div>
                        <div class="row">
                            <div class="progress" style="width: 90%">
                                <div class="progress-bar" role="progressbar"
                                     aria-valuenow="${book.currentPage}" aria-valuemin="0"
                                     aria-valuemax="${book.pageCount}" <#--style="width: ${book.currentPage/book.pageCount*100}%"-->>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
        <#include "pagination.ftl">
    </div>
</div>
</@layout.page>