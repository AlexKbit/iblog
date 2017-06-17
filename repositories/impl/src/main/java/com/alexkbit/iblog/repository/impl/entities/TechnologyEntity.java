package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Entity of technology
 */
@Entity
@Table(name = "technology")
public class TechnologyEntity extends TimeMarkEntity {

    /**
     * Name of technology
     */
    @Column(name = "tech_name")
    private String name;

    /**
     * Description for this technology
     */
    @Column(name = "tech_description")
    private String description;

    /**
     * Image of technology
     */
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="tech_image")
    private ImageEntity image;

    @ManyToMany(mappedBy="technologies")
    private List<ResumeEntity> resumes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public List<ResumeEntity> getResumes() {
        return resumes;
    }

    public void setResumes(List<ResumeEntity> resumes) {
        this.resumes = resumes;
    }
}
