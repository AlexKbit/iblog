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

}
