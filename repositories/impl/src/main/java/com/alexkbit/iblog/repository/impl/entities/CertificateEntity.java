package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Model of Certificate
 */
@Entity
@Table(name = "certificate")
public class CertificateEntity extends TimeMarkEntity {

    /**
     * Resume
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cert_resume")
    private ResumeEntity resume;

    /**
     * Name of certificate
     */
    @Column(name = "cert_name")
    private String name;

    /**
     * Date of create
     */
    @Column(name = "cert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /**
     * Link to resource
     */
    @Column(name = "cert_url", length = 1024)
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

    public ResumeEntity getResume() {
        return resume;
    }

    public void setResume(ResumeEntity resume) {
        this.resume = resume;
    }
}
