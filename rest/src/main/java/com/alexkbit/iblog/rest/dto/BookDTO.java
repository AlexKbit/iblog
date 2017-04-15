package com.alexkbit.iblog.rest.dto;

import com.alexkbit.iblog.model.BookLanguage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * DTO for book
 */
public class BookDTO extends BaseDTO {

    private String name = "";

    private String author = "";

    private String imageId;

    private String pageCount = "1";

    private String currentPage = "0";

    private BookLanguage language = BookLanguage.EN;

    private String publishYear = Integer.toString(LocalDate.now().getYear());

    private Double rate = 0D;

    private String endDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public BookLanguage getLanguage() {
        return language;
    }

    public void setLanguage(BookLanguage language) {
        this.language = language;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
