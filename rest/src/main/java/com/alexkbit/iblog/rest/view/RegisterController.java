package com.alexkbit.iblog.rest.view;

import com.alexkbit.iblog.rest.view.form.UserRegisterForm;
import com.alexkbit.iblog.rest.view.validator.UserRegisterValidator;
import com.alexkbit.iblog.servvices.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Savchenko.Ale on 27.02.2017.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegisterValidator userRegisterValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userRegisterValidator);
    }

    @RequestMapping(value = "/register/new", method = RequestMethod.POST)
    public String registerNewForm(@Valid @ModelAttribute("form") UserRegisterForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            userService.register(form.toUser());
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("error.login_or_email.exists", "Email or login already exists");
            return "register";
        }
        return "register_success";
    }

    @RequestMapping(value = "/register/new", method = RequestMethod.GET)
    public String registerNew() {
        return "register";
    }

    @RequestMapping(value = "/register/success", method = RequestMethod.GET)
    public String registerSuccess() {
        return "register_success";
    }


}
