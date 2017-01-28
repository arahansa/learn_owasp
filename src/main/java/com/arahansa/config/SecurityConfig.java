package com.arahansa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jarvis on 2017. 1. 11..
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


  // 1.2. http 설정
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .antMatchers("/**").permitAll();

    http.formLogin().loginPage("/login").permitAll();
  }


}
