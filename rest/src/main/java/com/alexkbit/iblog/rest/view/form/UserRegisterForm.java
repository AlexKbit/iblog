package com.alexkbit.iblog.rest.view.form;

import com.alexkbit.iblog.model.Role;
import com.alexkbit.iblog.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Savchenko.Ale on 27.02.2017.
 */
public class UserRegisterForm {

    private String login;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String confirmPassword;

    private Role role = Role.USER;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setRole(role);
        user.setEnabled(true);
        user.setName(name);
        user.setSurname(surname);
        return user;
    }
}
