package com.project.ecommerce.projectEcommerce.configurations;


import com.project.ecommerce.projectEcommerce.Repository.UserAttemptsRepository;
import com.project.ecommerce.projectEcommerce.entities.UserAttempts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Component
public class LimitLoginAuthenticationHandler extends DaoAuthenticationProvider {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserAttemptsRepository userAttemptsRepository;

    @Autowired
    @Override
    public void setUserDetailsService(@Qualifier("appUserDetailsService") UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        try {

            Authentication auth = super.authenticate(authentication);


            //if reach here, means login success, else an exception will be thrown
            //reset the user_attempts
            userService.resetFailAttempts(authentication.getName());

            return auth;

        } catch (LockedException e){

            //this user is locked!
            String error = "";
            UserAttempts userAttempts = userAttemptsRepository.findByUsername(authentication.getName());
            if(userAttempts!=null){
                Date lastAttempts = userAttempts.getLastModified();
                error = "User account is locked! Username : " + authentication.getName() + "Last Attempts : " + lastAttempts;
            }else{
                error = e.getMessage();
            }

            throw new LockedException(error);
        }catch (BadCredentialsException e) {

            //invalid login, update to user_attempts
            userService.updateFailAttempts(authentication.getName());
            throw e;

        }

    }
}
