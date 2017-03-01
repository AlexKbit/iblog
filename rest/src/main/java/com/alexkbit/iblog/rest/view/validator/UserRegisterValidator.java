package com.alexkbit.iblog.rest.view.validator;

import com.alexkbit.iblog.rest.view.form.UserRegisterForm;
import com.alexkbit.iblog.servvices.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Savchenko.Ale on 27.02.2017.
 */
@Component
public class UserRegisterValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserRegisterForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }

    private void validatePasswords(Errors errors, UserRegisterForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("error.incorrect.passwordMatch");
        }
    }

    private void validateEmail(Errors errors, UserRegisterForm form) {
        if (userService.getByEmail(form.getEmail()) != null) {
            errors.reject("error.incorrect.email.exist");
        }
    }
}
