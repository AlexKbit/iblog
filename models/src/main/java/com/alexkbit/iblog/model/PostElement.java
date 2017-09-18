package com.alexkbit.iblog.model;

/**
 * Element of {@link Post}.
 */
public class PostElement extends BaseModel {

    /**
     * Content of post element.
     */
    private String content;

    /**
     * Type of post.
     */
    private PostElementType type;

    /**
     * Number of order.
     */
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
