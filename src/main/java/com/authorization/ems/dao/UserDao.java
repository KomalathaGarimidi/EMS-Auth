package com.authorization.ems.dao;

import com.authorization.ems.pojo.UserEmp;

import java.util.Optional;

public interface UserDao {

    //creating and saving user to db
    int saveUser(UserEmp userEmp);

    //checking whether the username exists or not
    boolean existsByName(String username);

    //checking whether the useremail exists or not
    boolean existsByEmail(String email);

    //findByUserName
    Optional<UserEmp> findByUserName(String username);
    Optional<UserEmp> findByEmail(String email);
}
