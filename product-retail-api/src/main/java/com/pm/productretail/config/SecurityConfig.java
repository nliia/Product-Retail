package com.pm.productretail.config;

import com.pm.productretail.security.JWTAuthenticationProvider;
import com.pm.productretail.security.JWTFilter;
import com.pm.productretail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author lnurullina
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    @Autowired
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Order
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/sign_in").permitAll()
                .anyRequest().authenticated()
                .and()
                .antMatcher("/secure/**")
                .addFilterBefore(new JWTFilter(new JWTAuthenticationProvider(userService)), BasicAuthenticationFilter.class);

    }

}
