package com.authorization.ems.service.impl;

import com.authorization.ems.dao.UserDao;
import com.authorization.ems.exception.UserEmailAlreadyExists;
import com.authorization.ems.exception.UserNameAlreadyExists;
import com.authorization.ems.pojo.UserEmp;
import com.authorization.ems.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserDao userDao;

    @Override
    public void registerUser(UserEmp userEmp) throws UserNameAlreadyExists, UserEmailAlreadyExists {
        System.out.println("This is from AuthServiceImpl");
        System.out.println("UserDao || "+userDao);

        if(userDao.existsByName(userEmp.getUsername())){
            throw new UserNameAlreadyExists(userEmp.getUsername());
        }
        else if(userDao.existsByEmail(userEmp.getEmail())){
            throw new UserEmailAlreadyExists(userEmp.getEmail());
        }
        else{
            userDao.saveUser(userEmp);

        }

        userDao.saveUser(userEmp);

        System.out.println("UserEmp || "+userEmp);
    }

    @Override
    public Optional<UserEmp> findByUserName(String username) {
        Optional<UserEmp> result = userDao.findByUserName(username);
        return result;
    }


    @Override
    public Optional<UserEmp> findByEmail(String email) {
        Optional<UserEmp> result = userDao.findByEmail(email);
        return result;
    }
}
