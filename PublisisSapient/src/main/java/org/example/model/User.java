package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Slf4j
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    @NotBlank(message = "User name must not be blank")
    @Size(min = 2, message = "User name must be at least 2 characters long")
    String userName;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    String email;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Transient
    @JsonIgnore // Don't want to show this in REST API response
    String password;

    @CreatedDate
    LocalDateTime registrationDate;
}
