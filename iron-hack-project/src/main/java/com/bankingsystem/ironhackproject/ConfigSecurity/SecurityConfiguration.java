package com.bankingsystem.ironhackproject.ConfigSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {
    @Autowired
    CustomUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and().build();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/account/").hasAnyRole("ADMIN", "USER")
                .mvcMatchers(HttpMethod.GET, "/account-holder/").hasAnyRole("ADMIN", "USER")
                .mvcMatchers(HttpMethod.GET, "/admin/").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.PATCH, "/account/transfer").hasAnyRole("ADMIN", "USER")
                .mvcMatchers(HttpMethod.PATCH, "/account/deposit").hasAnyRole("ADMIN", "THIRD_PARTY")
                .mvcMatchers(HttpMethod.PATCH, "/").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/").hasRole("ADMIN")
                .anyRequest().authenticated();

        return http.build();
    }
}
