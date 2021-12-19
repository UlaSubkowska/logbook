package com.akw.logbook;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//TODO consider if this is the way to tell String which endpoint should not be secured, maybe find better way of doing so
// something with roles ??? read more about spring security
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/register", "/process_register").permitAll()
                .anyRequest().authenticated();
//            .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//            .and()
//                .logout()
//                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/webjars/**");
    }
}
