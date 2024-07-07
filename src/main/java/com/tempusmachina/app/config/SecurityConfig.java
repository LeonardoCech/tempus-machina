package com.tempusmachina.app.config;

import com.tempusmachina.app.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ProfileService profileService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(
                		"/", 
                		"/api-doc", 
                		"/signin", 
                		"/signup", 
                		"/profiles/**",
                		"/media",
                		"/medias/**",
                		"/v2/api-docs",
                		"/v3/api-docs",
                		"/v3/api-docs/**",
                		"/swagger-resources",
                		"/swagger-resources/**",
                		"/configuration/ui",
                		"/configuration/security",
                		"/swagger-ui/**",
                		"/webjars/**",
                		"/swagger-ui.html"
                	).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/signin")
                .defaultSuccessUrl("/profiles/medias", true)
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            )
            .userDetailsService(profileService)
            .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
