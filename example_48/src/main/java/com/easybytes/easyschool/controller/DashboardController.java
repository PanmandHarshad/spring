package com.easybytes.easyschool.controller;

import com.easybytes.easyschool.model.Person;
import com.easybytes.easyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession httpSession) {
        Person person = personRepository.readByEmail(authentication.getName());

        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        httpSession.setAttribute("loggedInPerson", person);

        if (null != person.getEazyClass() && null != person.getEazyClass().getName()) {
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }

        //throw new RuntimeException("It's been a bad day !!");
        return "dashboard.html";
    }

    private void logMessages() {
        log.error("Error message from the Dashboard page");
        log.warn("Warning message from the Dashboard page");
        log.info("Info message from the Dashboard page");
        log.debug("Debug message from the Dashboard page");
        log.trace("Trace message from the Dashboard page");
    }

}