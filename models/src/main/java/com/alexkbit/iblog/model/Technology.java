package com.alexkbit.iblog.model;

/**
 * Model for technology
 */
public class Technology extends BaseModel {

    /**
     * Name of technology
     */
    private String name;

    /**
     * Description for this technology
     */
    private String description;

    /**
     * Image of technology
     */
    private Image image;

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
