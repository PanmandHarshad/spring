package com.easybytes.easyschool.controller;

import com.easybytes.easyschool.model.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProfileController {

    @RequestMapping("/displayProfile")
    public ModelAndView displayProfile(Model model) {
        ModelAndView modelAndView = new ModelAndView("profile.html");
        Profile profile = new Profile();
        modelAndView.addObject("profile", profile);
        return modelAndView;
    }
}
