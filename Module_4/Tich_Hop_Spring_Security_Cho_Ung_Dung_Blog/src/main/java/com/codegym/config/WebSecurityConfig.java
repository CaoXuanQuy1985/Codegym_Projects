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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        for (User user : interfaceUserService.findAll()) {
            if (user.getUsername() != null && user.getPassword() != null) {
                if (user.getAccount().getRole().equals("user")) {
                    auth.inMemoryAuthentication()
                            .withUser(user.getUsername()).password(user.getPassword()).roles("USER");
                } else {
                    auth.inMemoryAuthentication()
                            .withUser(user.getUsername()).password(user.getPassword()).roles("ADMIN");
                }
            }
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/user**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
