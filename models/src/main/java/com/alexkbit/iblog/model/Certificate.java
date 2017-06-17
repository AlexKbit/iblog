package com.alexkbit.iblog.model;

import java.util.Date;

/**
 * Model of Certificate
 */
public class Certificate extends TimeMarkModel {

    /**
     * Name of certificate
     */
    private String name;

    /**
     * Date of create
     */
    private Date date;

    /**
     * Link to resource
     */
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
