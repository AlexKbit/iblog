package com.alexkbit.iblog.rest.dto;

import com.alexkbit.iblog.model.Role;

/**
 * DTO for User
 */
public class UserDTO extends BaseDTO {

    /**
     * Login in the system
     */
    private String login;

    /**
     * User email
     */
    private String email;

    /**
     * User name
     */
    private String name;

    /**
     * User surname
     */
    private String surname;

    /**
     * User avatar
     */
    private String avatarId;

    /**
     * User role
     */
    private Role role;

    /**
     * Is user enabled
     */
    private boolean enabled;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
