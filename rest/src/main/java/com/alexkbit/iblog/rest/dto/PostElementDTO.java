package com.alexkbit.iblog.rest.dto;

import com.alexkbit.iblog.model.PostElementType;

/**
 * DTO for post.
 */
public class PostElementDTO extends BaseDTO {

    private String content;
    private PostElementType type;
    private int order;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostElementType getType() {
        return type;
    }

    public void setType(PostElementType type) {
        this.type = type;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
