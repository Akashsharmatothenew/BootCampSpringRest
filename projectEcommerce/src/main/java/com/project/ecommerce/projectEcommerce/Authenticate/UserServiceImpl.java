package com.project.ecommerce.projectEcommerce.Authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl {
    @Autowired
    UserDao userDao;

    public void updateFailAttempts(String username) {
        userDao.updateFailAttempts(username);

    }

    public void resetFailAttempts(String username) {
        userDao.resetFailAttempts(username);

    }
}
