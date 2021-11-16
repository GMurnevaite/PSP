package com.psp3.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String showRootPage(ModelMap model) {
        model.put("name", "ANONYMOUS");
        return "home";
    }

    @GetMapping("/home") //
    public String showWelcomePage(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        return "home";
    }

}
