package com.easybytes.easyschool.controller;

import com.easybytes.easyschool.model.Contact;
import com.easybytes.easyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = {"/contact"})
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact("", "", "", "", ""));
        return "contact.html";
    }

//    @RequestMapping(value = "saveMsg", method = RequestMethod.POST)
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject,
//                                    @RequestParam String message) {
//
//        logger.info("Name: " + name);
//        logger.info("Mobile Number: " + mobileNum);
//        logger.info("Email: " + email);
//        logger.info("Subject: " + subject);
//        logger.info("Message: " + message);
//
//        return new ModelAndView("redirect:/contact");
//    }

    @RequestMapping(value = "saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation is failed due to: " + errors);
            return "contact.html";
        }

        contactService.saveMessageDetails(contact);
        contactService.setCounter(contactService.getCounter() + 1);
        log.info("Number of times contact form is submitted : " + contactService.getCounter());

        // This "redirect:/contact" is loading the fresh page
        return "redirect:/contact";
    }
}
