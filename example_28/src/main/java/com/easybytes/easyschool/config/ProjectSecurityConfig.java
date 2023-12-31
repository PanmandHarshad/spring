package com.easybytes.easyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /**
         By default, any request with HTTP method that can update data like POST,
         PUT will be stopped with 403 error due to CSRF protection

         This is handled in thymeleaf itself.
         This is needed only if your application is developed using simple html pages
         */
        http.csrf((csrf) -> csrf.disable());

        http.authorizeHttpRequests(requests ->
                requests.requestMatchers("", "/", "/home").permitAll()
                        .requestMatchers("/holidays/all").authenticated()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .anyRequest().denyAll());

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());

        return http.build();
    }
}
