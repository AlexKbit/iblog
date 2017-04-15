package com.alexkbit.iblog.model;

import java.util.Date;

/**
 * Model with time marks
 */
public class TimeMarkModel extends BaseModel {

    private Date createdAt;

    private Date updatedAt;

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
