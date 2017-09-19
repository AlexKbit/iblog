package com.alexkbit.iblog.rest.dto;

import com.alexkbit.iblog.model.Image;

import java.util.List;

/**
 * DTO for post.
 */
public class PostDTO extends BaseDTO {

    private String theme;

    private Image imageId;

    private List<TechnologyDTO> tags;

    private List<PostElementDTO> elements;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Image getImageId() {
        return imageId;
    }

    public void setImageId(Image imageId) {
        this.imageId = imageId;
    }

    public List<TechnologyDTO> getTags() {
        return tags;
    }

    public void setTags(List<TechnologyDTO> tags) {
        this.tags = tags;
    }

    public List<PostElementDTO> getElements() {
        return elements;
    }

    public void setElements(List<PostElementDTO> elements) {
        this.elements = elements;
    }
}
