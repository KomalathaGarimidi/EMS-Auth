package com.authorization.ems.controller;

import com.authorization.ems.exception.UserEmailAlreadyExists;
import com.authorization.ems.exception.UserNameAlreadyExists;
import com.authorization.ems.pojo.UserEmp;
import com.authorization.ems.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth/user")
public class  AuthController {


    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserEmp userEmp) throws UserNameAlreadyExists, UserEmailAlreadyExists {

        System.out.println("From AuthController");

        authService.registerUser(userEmp);

        System.out.println("authService || "+authService);
        return new ResponseEntity(userEmp, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    ResponseEntity findByUserName(@PathVariable String username){
        Optional<UserEmp> result=authService.findByUserName(username);
        if(result.isEmpty()){
            return new ResponseEntity(result,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result,HttpStatus.FOUND);
    }

    @GetMapping("/mail/{email}")
    ResponseEntity findByEmail(@PathVariable String email){
        Optional<UserEmp> result=authService.findByEmail(email);
        if(result.isEmpty()){
            return new ResponseEntity(result,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result,HttpStatus.FOUND);
    }

}
