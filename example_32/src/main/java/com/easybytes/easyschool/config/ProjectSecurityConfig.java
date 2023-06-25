package com.easybytes.easyschool.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/saveMsg"));
        http.csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()));

        http.authorizeHttpRequests(requests ->
                requests
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/displayMessages").hasRole("ADMIN")
                        .requestMatchers("", "/", "/home").permitAll()
                        .requestMatchers("/holidays/all").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .anyRequest().denyAll());

        // Disabling header, so that h2-console will be displayed
        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        http.formLogin(formLogin ->
                formLogin
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
        );

        http.logout(logout ->
                logout
                        .logoutSuccessUrl("/login?error=false")
                        .invalidateHttpSession(true)
                        .permitAll());

        http.httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails userHarshad = User.withDefaultPasswordEncoder()
                .username("Harshad")
                .password("12345")
                .roles("USER") // Here spring will add 'ROLE_' before 'USER', so role name will be 'ROLE_USER'
                .build();

        UserDetails amdin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("54321")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userHarshad, amdin);
    }
}
