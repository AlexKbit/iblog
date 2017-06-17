package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Model of user resume
 */
@Entity
@Table(name = "resume")
public class ResumeEntity extends TimeMarkEntity {

    /**
     * User of resume
     */
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="res_user")
    private UserEntity user;

    /**
     *  Some text about user
     */
    @Column(name = "res_about")
    private String aboutMe;

    /**
     * List of technologies
     */
    @OneToMany(mappedBy="resume")
    private List<TechnologyEntity> technologies;

    /**
     * List of work positions
     */
    @OneToMany(mappedBy="resume")
    private List<WorkPositionEntity> positions;

    /**
     * List of certificates
     */
    @OneToMany(mappedBy="resume")
    private List<CertificateEntity> certificates;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public List<TechnologyEntity> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyEntity> technologies) {
        this.technologies = technologies;
    }

    public List<WorkPositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(List<WorkPositionEntity> positions) {
        this.positions = positions;
    }

    public List<CertificateEntity> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificateEntity> certificates) {
        this.certificates = certificates;
    }
}

