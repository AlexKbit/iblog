package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Entity with marks of time
 */
@MappedSuperclass
public class TimeMarkEntity extends BaseEntity {

    public TimeMarkEntity() {
        super();
    }

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    @PreUpdate
    public void init() {
        super.init();
        if (createdAt == null) {
            createdAt = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        }
        updatedAt = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
