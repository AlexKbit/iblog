package com.alexkbit.iblog.rest.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample REST Controller
 */
@RestController
public class HelloController {

    @RequestMapping("/hi")
    public String hello() {
        return "Hi user!";
    }
}
