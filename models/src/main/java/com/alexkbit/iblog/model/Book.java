package com.alexkbit.iblog.model;

import java.util.Date;

/**
 * Model of book
 */
public class Book extends TimeMarkModel {

    /**
     * Name of book
     */
    private String name;

    /**
     * Name of author
     */
    private String author;

    /**
     * Owner of book
     */
    private User user;

    /**
     * Count of pages
     */
    private Integer pageCount;

    /**
     * Book current page
     */
    private Integer currentPage;

    /**
     * Image of album page
     */
    private Image image;

    /**
     * Book language
     */
    private BookLanguage language;

    /**
     * Year publish of book
     */
    private Integer publishYear;

    /**
     * Book rate
     */
    private Double rate;

    /**
     * Date for end of read
     */
    private Date endDate;

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

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public BookLanguage getLanguage() {
        return language;
    }

    public void setLanguage(BookLanguage language) {
        this.language = language;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
