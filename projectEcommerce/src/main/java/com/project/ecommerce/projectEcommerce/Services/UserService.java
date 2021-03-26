package com.project.ecommerce.projectEcommerce.Services;

import com.project.ecommerce.projectEcommerce.Entity.Role;
import com.project.ecommerce.projectEcommerce.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ttn on 26/3/21.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


}
