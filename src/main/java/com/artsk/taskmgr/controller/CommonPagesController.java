package com.artsk.taskmgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 1gnite.
 */
@Controller
@RequestMapping(value = {"/", "/home"})
public class CommonPagesController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
}
