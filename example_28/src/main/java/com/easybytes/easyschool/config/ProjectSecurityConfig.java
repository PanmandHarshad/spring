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
        // TODO: Here pages that are marked as authenticated are not asking for authentication,
        //  need to take case of those
        http.authorizeHttpRequests(requests ->
                requests.requestMatchers("/home").permitAll()
                        .requestMatchers("/holidays").authenticated()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").authenticated()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .anyRequest().authenticated());

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());

        return http.build();
    }
}
