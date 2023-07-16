package com.easybytes.easyschool.proxy;


import com.easybytes.easyschool.config.ProjectConfiguration;
import com.easybytes.easyschool.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "contact", url = "http://localhost:8080/api/contact",
        configuration = ProjectConfiguration.class)
public interface ContactProxy {

    @GetMapping("/getMessagesByStatus")
    // Accepting and returning the data in JSON format, content type JSON is default format
    @Headers(value = "Content-Type: application/json")
        // This method signature should match to method what we have Original ContactRestController
        // Method name can be different but i/p and o/p should be same
    List<Contact> getMessagesByStatus(@RequestParam("status") String status);

}
