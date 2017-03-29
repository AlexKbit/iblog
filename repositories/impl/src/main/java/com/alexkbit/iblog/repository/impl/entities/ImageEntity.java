package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * Entity for images
 */
@Entity
@Table(name = "image", schema = "public")
public class ImageEntity extends TimeMarkEntity {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="img_user")
    private UserEntity user;

    /**
     * Name of image
     */
    @Column(name = "img_name")
    private String name;

    /**
     * Data of image
     */
    @Lob
    @Basic(fetch=LAZY)
    @Column(name="img_data")
    private byte[] data;

    /**
     * Type of image
     */
    @Column(name = "img_type")
    @Enumerated(EnumType.STRING)
    private ImageType type;

    @OneToMany(mappedBy="image")
    private List<BookEntity> books;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
