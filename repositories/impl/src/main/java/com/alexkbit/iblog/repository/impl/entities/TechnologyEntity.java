package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;

/**
 * Entity of technology
 */
@Entity
@Table(name = "technology")
public class TechnologyEntity extends BaseEntity {

    /**
     * Name of technology
     */
    @Column(name = "tech_name")
    private String name;

    /**
     * Resume
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tech_resume")
    private ResumeEntity resume;

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

    public ResumeEntity getResume() {
        return resume;
    }

    public void setResume(ResumeEntity resume) {
        this.resume = resume;
    }
}
