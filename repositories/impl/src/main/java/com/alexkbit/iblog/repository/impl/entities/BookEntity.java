package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Entity of book
 */
public class BookEntity extends TimeMarkEntity {

    private String name;

    private String author;

    private Integer pageCount;

    private Integer currentPage;

    private ImageEntity image;

    private String language;

    private Integer publishYear;

    private Integer rate;

    @PrePersist
    @PreUpdate
    public void init() {
        super.init();
    }
}
