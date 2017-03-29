package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;

/**
 * Entity of book
 */
@Entity
@Table(name = "book", schema = "public")
public class BookEntity extends TimeMarkEntity {

    /**
     * Name of book
     */
    @Column(name = "book_name")
    private String name;

    /**
     * Name of author
     */
    @Column(name = "book_author")
    private String author;

    /**
     * Count of pages
     */
    @Column(name = "book_page_count")
    private Integer pageCount;

    /**
     * Book current page
     */
    @Column(name = "book_current_page")
    private Integer currentPage;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="book_user")
    private UserEntity user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="book_image")
    private ImageEntity image;

    /**
     * Book language
     */
    @Column(name = "book_language")
    @Enumerated(EnumType.STRING)
    private BookLanguageEntity language;

    /**
     * Year publish of book
     */
    @Column(name = "book_publish_year")
    private Integer publishYear;

    /**
     * Book rate
     */
    @Column(name = "book_rate")
    private Double rate;

    @PrePersist
    @PreUpdate
    public void init() {
        super.init();
    }

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

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public BookLanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(BookLanguageEntity language) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
