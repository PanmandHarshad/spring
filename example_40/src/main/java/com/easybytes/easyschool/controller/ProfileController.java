package com.easybytes.easyschool.controller;

import com.easybytes.easyschool.model.Address;
import com.easybytes.easyschool.model.Person;
import com.easybytes.easyschool.model.Profile;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProfileController {

    @RequestMapping("/displayProfile")
    public ModelAndView displayProfile(Model model, HttpSession httpSession) {
        Person loggedInPerson = (Person) httpSession.getAttribute("loggedInPerson");

        Profile profile = new Profile();
        profile.setName(loggedInPerson.getName());
        profile.setMobileNumber(loggedInPerson.getMobileNumber());
        profile.setEmail(loggedInPerson.getEmail());

        Address address = loggedInPerson.getAddress();
        if (address != null && address.getAddressId() > 0) {
            profile.setAddress1(address.getAddress1());
            profile.setAddress2(address.getAddress2());
            profile.setCity(address.getCity());
            profile.setState(address.getState());
            profile.setZipCode(address.getZipCode());
        }

        ModelAndView modelAndView = new ModelAndView("profile.html");
        modelAndView.addObject("profile", profile);
        return modelAndView;
    }
}
