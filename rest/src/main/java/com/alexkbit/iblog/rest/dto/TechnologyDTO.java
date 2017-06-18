package com.alexkbit.iblog.rest.dto;

/**
 * DTO for technology
 */
public class TechnologyDTO extends BaseDTO {

    private String name = "";

    private String description = "";

    private String imageId;

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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
