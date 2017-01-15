package com.alexkbit.iblog.repository.impl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Entity of user
 */
@Entity
public class UserEntity extends TimeMarkEntity {

    @PrePersist
    @PreUpdate
    public void init() {
        super.init();
    }

    /**
     * Login in the system
     */
    @Column(name = "usr_login", length = 128)
    private String login;

    /**
     * User password
     */
    @Column(name = "usr_password")
    private String password;

    /**
     * User email
     */
    @Column(name = "usr_email")
    private String email;

    /**
     * User name
     */
    @Column(name = "usr_name")
    private String name;

    /**
     * User surname
     */
    @Column(name = "usr_surname")
    private String surname;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
