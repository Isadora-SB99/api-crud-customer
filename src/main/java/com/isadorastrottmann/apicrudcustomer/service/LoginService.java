package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.infra.security.TokenService;
import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.LoginDto;
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

    public ResponseEntity<?> login(LoginDto loginDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.email(),
                loginDto.password());

        var authentication = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateToken((Customer) authentication.getPrincipal());

        return ResponseEntity.ok(tokenJwt);
    }
}
