package com.example.demooauth2forcloudio.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("ALL")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/endpoint").hasRole("oiken")
                .antMatchers("/api/test/message").hasRole("user")
                .antMatchers(HttpMethod.DELETE, "/api/endpoint/{endPointId}").hasRole("oiken")
                .antMatchers("/api/endpoint/{endPointId}").hasRole("oiken")
                .anyRequest()
                .authenticated()

                .and()
                .oauth2ResourceServer()
                .jwt();
    }
}
