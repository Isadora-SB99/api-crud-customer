package com.isadorastrottmann.apicrudcustomer.controller;

import com.isadorastrottmann.apicrudcustomer.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody String email, @RequestBody String password){
        return loginService.login(email, password);
    }
}
