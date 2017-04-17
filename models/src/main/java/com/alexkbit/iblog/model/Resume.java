package com.alexkbit.iblog.model;

import java.util.List;

/**
 * Model of user resume
 */
public class Resume extends BaseModel {

    /**
     * User of resume
     */
    private User user;

    /**
     *  Some text about user
     */
    private String aboutMe;

    /**
     * List of technologies
     */
    private List<Technology> technologies;

    /**
     * List of work positions
     */
    private List<WorkPosition> positions;

    /**
     * List of certificates
     */
    private List<Certificate> certificates;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    public List<WorkPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<WorkPosition> positions) {
        this.positions = positions;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}

