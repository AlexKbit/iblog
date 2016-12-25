package com.alexkbit.iblog.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample REST Controller
 */
@RestController
public class SampleController {

    @RequestMapping("/hi")
    public String hello() {
        return "Hi user!";
    }
}
