package com.authorization.ems.service;

import com.authorization.ems.exception.UserEmailAlreadyExists;
import com.authorization.ems.exception.UserNameAlreadyExists;
import com.authorization.ems.pojo.UserEmp;

import java.util.Optional;

public interface AuthService {

    void registerUser(UserEmp userEmp) throws UserNameAlreadyExists, UserEmailAlreadyExists;
    Optional<UserEmp> findByUserName(String username);
    public Optional<UserEmp> findByEmail(String email);
}
