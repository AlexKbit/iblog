package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Entity of post.
 */
@Entity
@Table(name = "post", schema = "public")
public class PostEntity extends TimeMarkEntity {

    /**
     * Owner of post.
     */
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="post_user")
    private UserEntity user;

    /**
     * Theme of post.
     */
    @Column(name = "post_theme", length = 65536)
    private String theme;

    /**
     * Main image of post.
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="post_image")
    private ImageEntity cover;

    /**
     * Elements of post.
     */
    @OneToMany(mappedBy="post")
    private List<PostElementEntity> elementList;

    /**
     * Tags of post.
     */
    @ManyToMany
    @JoinTable(
            name="post_technologies",
            joinColumns=@JoinColumn(name="post", referencedColumnName="uuid"),
            inverseJoinColumns=@JoinColumn(name="technology", referencedColumnName="uuid"))
    private List<TechnologyEntity> tags;

    /**
     * Visibility of post.
     */
    @Column(name = "post_visible")
    private boolean visible = true;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public ImageEntity getCover() {
        return cover;
    }

    public void setCover(ImageEntity cover) {
        this.cover = cover;
    }

    public List<PostElementEntity> getElementList() {
        return elementList;
    }

    public void setElementList(List<PostElementEntity> elementList) {
        this.elementList = elementList;
    }

    public List<TechnologyEntity> getTags() {
        return tags;
    }

    public void setTags(List<TechnologyEntity> tags) {
        this.tags = tags;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
