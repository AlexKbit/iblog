package com.alexkbit.iblog.rest.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Savchenko.Ale on 31.01.2017.
 */
@Controller
public class AboutMeController {

    @RequestMapping(value="/aboutMe", method = RequestMethod.GET)
    public String index(Model model) {
        return "aboutMe";
    }
}
