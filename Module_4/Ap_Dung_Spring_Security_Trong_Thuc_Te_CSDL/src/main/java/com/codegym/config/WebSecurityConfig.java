package com.codegym.config;

import com.codegym.model.User;
import com.codegym.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private InterfaceUserService interfaceUserService;

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        for (User user : interfaceUserService.findAll()) {
            if (user.getUsername() != null && user.getPassword() != null) {
                if (user.getAccount().getRole().equals("dba")) {
                    auth.inMemoryAuthentication()
                            .withUser(user.getUsername()).password(user.getPassword()).roles("DBA", "ADMIN");
                } else if (user.getAccount().getRole().equals("admin")) {
                    auth.inMemoryAuthentication()
                            .withUser(user.getUsername()).password(user.getPassword()).roles("ADMIN");
                } else {
                    auth.inMemoryAuthentication()
                            .withUser(user.getUsername()).password(user.getPassword()).roles("USER");
                }
            }
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").access("hasRole('USER') and hasRole('ADMIN') and hasRole('DBA')")
                //.antMatchers("/", "/home").access("hasRole('USER')")
                .antMatchers("/user**").access("hasRole('USER')")
                .antMatchers("/admin**").access("hasRole('ADMIN')")
                .antMatchers("/dba**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().successHandler(customSuccessHandler)
                .usernameParameter("ssoId").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
