package com.alexkbit.iblog.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model of user resume
 */
public class Resume extends TimeMarkModel {

    /**
     * User of resume
     */
    private User user;

    /**
     *  Some text about user
     */
    private String aboutMe;

    /**
     * Set of technologies
     */
    private List<Technology> technologies = new ArrayList<>();

    /**
     * List of work positions
     */
    private List<WorkPosition> positions = new ArrayList<>();

    /**
     * List of certificates
     */
    private List<Certificate> certificates = new ArrayList<>();

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

