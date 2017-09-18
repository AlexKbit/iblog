package com.alexkbit.iblog.repository.impl.entities;

import com.alexkbit.iblog.model.Post;

import javax.persistence.*;

/**
 * Element of {@link Post}.
 */
@Entity
@Table(name = "post_element", schema = "public")
public class PostElementEntity extends BaseEntity {

    /**
     * Resume
     */
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="pe_post")
    private PostEntity post;

    /**
     * Content of post element.
     */
    @Column(name = "pe_content")
    private String content;

    /**
     * Type of post.
     */
    @Column(name = "pe_type")
    @Enumerated(EnumType.STRING)
    private PostElementType type;

    /**
     * Number of order.
     */
    @Column(name = "pe_order")
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

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }
}
