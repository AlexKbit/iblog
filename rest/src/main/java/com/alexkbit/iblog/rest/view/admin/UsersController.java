package com.alexkbit.iblog.rest.view.admin;

import com.alexkbit.iblog.servvices.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Sample REST Controller
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("admin")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ModelAndView get() {
        return new ModelAndView("admin/users", "users", userService.get(0, 25));
    }
}
