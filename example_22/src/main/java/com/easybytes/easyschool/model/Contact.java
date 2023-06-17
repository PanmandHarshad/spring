package com.easybytes.easyschool.model;


/**
 * @Data annotation is provided by Lombok library which generates getter, setter,
 * equals(), hashCode(), toString() methods & Constructor at compile time.
 * This makes our code short and clean.
 */
public record Contact(String name, String mobileNum, String email, String subject, String message) {
}

