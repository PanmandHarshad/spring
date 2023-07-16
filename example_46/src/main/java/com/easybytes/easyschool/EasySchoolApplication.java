package com.easybytes.easyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.easybytes.easyschool.proxy")
public class EasySchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasySchoolApplication.class, args);
    }

}
