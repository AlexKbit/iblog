package com.alexkbit.iblog.rest.view.form;

import com.alexkbit.iblog.model.Book;
import com.alexkbit.iblog.model.BookLanguage;
import com.alexkbit.iblog.rest.formatters.DateFormatter;

import java.time.LocalDate;
import java.util.Date;

/**
 * Form for book
 */
public class BookForm {

    private String name = "";

    private String author = "";

    private String imageId;

    private int pageCount;

    private int currentPage;

    private BookLanguage language = BookLanguage.EN;

    private int publishYear = LocalDate.now().getYear();

    private double rate;

    private String endDate = DateFormatter.formatDate(new Date());

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

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public BookLanguage getLanguage() {
        return language;
    }

    public void setLanguage(BookLanguage language) {
        this.language = language;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Book toBook() {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setRate(rate);
        book.setPublishYear(publishYear);
        book.setCurrentPage(currentPage);
        book.setLanguage(language);
        book.setPageCount(pageCount);
        book.setEndDate(DateFormatter.parseDate(endDate));
        return book;
    }
}
