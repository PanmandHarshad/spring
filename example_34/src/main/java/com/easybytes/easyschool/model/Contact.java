package com.easybytes.easyschool.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record Contact(
        /**
         @NotNull: Checks if a given field is not null but allows empty values & zero elements inside collections.
         @NotEmpty: Checks if a given field is not null and its size/length is greater than zero.
         @NotBlank: Checks if a given field is not null and trimmed length is greater than zero.
         */
        Integer contactId,

        @NotBlank(message = "Name must not be blank")
        @Size(min = 3, message = "Name must be at least 3 characters long")
        String name,

        @NotBlank(message = "Mobile number must not be blank")
        @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
        String mobileNum,

        @NotBlank(message = "Email must not be blank")
        @Email(message = "Please provide a valid email address")
        String email,

        @NotBlank(message = "Subject must not be blank")
        @Size(min = 5, message = "Subject must be at least 5 characters long")
        String subject,

        @NotBlank(message = "Message must not be blank")
        @Size(min = 10, message = "Message must be at least 10 characters long")
        String message,

        String status,

        BaseEntity baseEntity
) {
}

