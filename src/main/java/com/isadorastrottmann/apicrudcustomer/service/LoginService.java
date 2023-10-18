package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<?> login(String email, String password) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        var authentication = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateToken((Customer) authentication.getPrincipal());

        return ResponseEntity.ok(tokenJwt);
    }
}
