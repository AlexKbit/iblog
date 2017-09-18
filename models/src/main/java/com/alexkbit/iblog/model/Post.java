package com.alexkbit.iblog.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Model for post.
 */
public class Post extends TimeMarkModel {

    /**
     * Owner of post.
     */
    private User user;

    /**
     * Theme of post.
     */
    private String theme;

    /**
     * Main image of post.
     */
    private Image cover;

    /**
     * Elements of post.
     */
    private List<PostElement> elementList = new ArrayList<>();

    /**
     * Tags of post.
     */
    private List<Technology> tags;

    /**
     * Visibility of post.
     */
    private boolean visible = true;

    public int maxOrder() {
        return elementList.stream().mapToInt(PostElement::getOrder).max().orElse(0);
    }

    public int nextOrder() {
        return elementList.stream().mapToInt(PostElement::getOrder).max().orElse(-1) + 1;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public List<PostElement> getElementList() {
        return elementList;
    }

    public void setElementList(List<PostElement> elementList) {
        this.elementList = elementList;
    }

    public void reorder() {
        elementList = elementList.stream()
                .sorted(Comparator.comparingInt(p -> p.getOrder()))
                .collect(Collectors.toList());
    }

    public List<Technology> getTags() {
        return tags;
    }

    public void setTags(List<Technology> tags) {
        this.tags = tags;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Optional<PostElement> findElement(int order) {
        return elementList.stream()
                .filter(el -> el.getOrder() == order)
                .findFirst();
    }
}
