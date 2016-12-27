package com.alexkbit.iblog.model;

/**
 * Model of user
 */
public class User extends BaseModel {

    /**
     * Login in the system
     */
    private String login;

    /**
     * User password
     */
    private byte[] password;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
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
