package com.easybytes.easyschool;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class EasySchoolAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasySchoolAdminApplication.class, args);
    }

}
