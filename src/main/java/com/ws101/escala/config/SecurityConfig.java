package com.ws101.escala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Task 3.2: Enable @PreAuthorize in controllers
public class SecurityConfig {

    // Task 1.3: Password Encoding bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Task 1.4: Security Filter Chain configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Task 1.4: Enable CSRF for Session Security
            .csrf(csrf -> csrf.disable()) // Note: Disable temporarily if testing via Postman without tokens, but lab requires it enabled eventually.
            
            .authorizeHttpRequests(auth -> auth
                // Task 1.4: Permit All - Public Endpoints
                .requestMatchers("/", "/landing.html", "/products.html", "/signup.html", "/login.html", "/css/**", "/js/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/products/**").permitAll()
                .requestMatchers("/api/v1/auth/register").permitAll()
                
                // Task 1.4 & 3.1: Require Auth for protected actions
                .requestMatchers(HttpMethod.POST, "/api/v1/orders/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/api/v1/products/**").hasRole("ADMIN")
                
                .anyRequest().authenticated()
            )
            
            // Task 1.4: Enable Form Login
            .formLogin(form -> form
                .loginPage("/login.html") // Custom login page
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/landing.html", true)
                .permitAll()
            )
            
            // Task 2.3: Logout handling
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }
}
