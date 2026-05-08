
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
@EnableMethodSecurity // Task 3.2: Method Security
public class SecurityConfig {

    // Task 1.3: Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Task 1.4: Filter Chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Note: Lab asks for CSRF enabled, but disable first for Postman testing
            .authorizeHttpRequests(auth -> auth
                // Permit All (Public)
                .requestMatchers("/", "/landing.html", "/products.html", "/signup.html", "/login.html", "/css/**", "/js/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/products/**").permitAll()
                .requestMatchers("/api/v1/auth/register").permitAll()
                
                // Protected
                .requestMatchers(HttpMethod.POST, "/api/v1/orders/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/api/v1/products/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form // Task 1.4: Form Login
                .loginPage("/login.html")
                .defaultSuccessUrl("/landing.html", true)
                .permitAll()
            )
            .logout(logout -> logout // Task 2.3: Logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html?logout")
            );

        return http.build();
    }
}
