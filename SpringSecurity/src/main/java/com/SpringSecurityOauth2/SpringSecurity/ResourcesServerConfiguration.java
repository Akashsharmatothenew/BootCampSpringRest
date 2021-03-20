package com.SpringSecurityOauth2.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;





/**
 * Created by ttn on 16/3/21.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ResourcesServerConfiguration extends ResourceServerConfigurer   {

    @Autowired
    AppUserDetailsService userDetailsService;

    public ResourcesServerConfiguration() {
        super();
    }

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").anonymous()
                .antMatchers("/admin/home").hasAnyRole("ADMIN")
                .antMatchers("/user/home").hasAnyRole("USER")
                .antMatchers("/doLogout").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable();
    }
}
