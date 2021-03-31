package com.project.ecommerce.projectEcommerce.Authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by ttn on 23/3/21.
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    AppUsersDetailsServices appUsersDetailsServices;

    public ResourceServerConfig() {
    }
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(appUsersDetailsServices);
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
                //.addFilterBefore(new CorsFilter(), SessionManagementFilter.class)
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/welcome").permitAll()
                .antMatchers("/api/swagger-ui.html").permitAll()
                .antMatchers("/swagger-ui.html**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()

                .antMatchers("/doLogout").hasAnyRole("ADMIN","BUYER","SELLER")

                .antMatchers("/customer/profile").hasAnyRole("BUYER")
                .antMatchers("/customer/update/profile").hasAnyRole("BUYER")
                .antMatchers("/customer/update/password").hasAnyRole("BUYER")
                .antMatchers("/customer/add/address").hasAnyRole("BUYER")
                .antMatchers("/customer/address").hasAnyRole("BUYER")
                .antMatchers("/customer/view/product").hasAnyRole("BUYER")
                .antMatchers("/customer/view/all/products").hasAnyRole("BUYER")
                .antMatchers("/customer/similar/products").hasAnyRole("BUYER")
                .antMatchers("/customer/all/categories").hasAnyRole("BUYER")
                .antMatchers("/customer/filter/categories").hasAnyRole("BUYER")
                .antMatchers("/customer/delete/address").hasAnyRole("BUYER")
                .antMatchers("customer/address").hasAnyRole("BUYER")
                .antMatchers("/customer/update/address").hasAnyRole("BUYER")


                .antMatchers("/seller/profile").hasAnyRole("SELLER")
                .antMatchers("/seller/update/password").hasAnyRole("SELLER")
                .antMatchers("/seller/update/profile").hasAnyRole("SELLER")
                .antMatchers("/seller/add/address").hasAnyRole("SELLER")
                .antMatchers("/seller/add/product").hasAnyRole("SELLER")
                .antMatchers("/seller/view/product").hasAnyRole("SELLER")
                .antMatchers("/seller/view/all/products").hasAnyRole("SELLER")
                .antMatchers("/seller/delete/product").hasAnyRole("SELLER")
                .antMatchers("/seller/update/product").hasAnyRole("SELLER")
                .antMatchers("/seller/add/product/variation").hasAnyRole("SELLER")
                .antMatchers("/seller/view/product/variation").hasAnyRole("SELLER")
                .antMatchers("/seller/view/all/product/variations").hasAnyRole("SELLER")
                .antMatchers("/seller/update/address").hasAnyRole("SELLER")
                .antMatchers("/seller/upload/image").hasAnyRole("SELLER")
                .antMatchers("/seller/update/product/variation").hasAnyRole("SELLER")
                .antMatchers("/seller/all/categories").hasAnyRole("SELLER")

                .antMatchers("/confirm/seller").permitAll()
                .antMatchers("/confirm/customer").permitAll()
                .antMatchers("/register/seller").permitAll()
                .antMatchers("/register/customer").permitAll()
                .antMatchers("/reactivate/link/customer").permitAll()
                .antMatchers("/receive/token").permitAll()
                .antMatchers("/reset/password").permitAll()
                .antMatchers("/user/role").permitAll()

                .antMatchers("/admin/sellers").hasAnyRole("ADMIN")
                .antMatchers("/admin/customers").hasAnyRole("ADMIN")
                .antMatchers("/admin/activate/customer").hasAnyRole("ADMIN")
                .antMatchers("/admin/activate/seller").hasAnyRole("ADMIN")
                .antMatchers("/admin/deactivate/customer").hasAnyRole("ADMIN")
                .antMatchers("/admin/deactivate/seller").hasAnyRole("ADMIN")
                .antMatchers("/admin/add/category").hasAnyRole("ADMIN")
                .antMatchers("/admin/view/category").hasAnyRole("ADMIN")
                .antMatchers("/admin/all/categories").hasAnyRole("ADMIN")
                .antMatchers("/admin/update/category").hasAnyRole("ADMIN")
                .antMatchers("/admin/add/metadata").hasAnyRole("ADMIN")
                .antMatchers("/admin/view/metadata").hasAnyRole("ADMIN")
                .antMatchers("/admin/add/metadatavalue").hasAnyRole("ADMIN")
                .antMatchers("/admin/update/metadatavalue").hasAnyRole("ADMIN")
                .antMatchers("/admin/activate/product").hasAnyRole("ADMIN")
                .antMatchers("/admin/deactivate/product").hasAnyRole("ADMIN")
                .antMatchers("/admin/view/product").hasAnyRole("ADMIN")
                .antMatchers("/admin/view/all/products").hasAnyRole("ADMIN")

                .antMatchers("/seller/upload/image").hasAnyRole("SELLER", "BUYER")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable();
    }
}
