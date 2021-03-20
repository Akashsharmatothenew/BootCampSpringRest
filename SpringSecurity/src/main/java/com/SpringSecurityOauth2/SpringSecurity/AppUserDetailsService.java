package com.SpringSecurityOauth2.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by ttn on 16/3/21.
 */
@Service
public class AppUserDetailsService implements UserDetailsService{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
         String encryptedPassword = passwordEncoder.encode("pass");
        System.out.println("Trying to authenticate user::"+s);
        System.out.println("Encrypted Password ::" +encryptedPassword);
        UserDetails userDetails = userDao.loadUserByUsername(s);
         return userDetails;
    }
}
