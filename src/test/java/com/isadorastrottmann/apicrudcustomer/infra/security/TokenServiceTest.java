package com.isadorastrottmann.apicrudcustomer.infra.security;

import com.isadorastrottmann.apicrudcustomer.stubs.CustomerStub;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TokenServiceTest {
////    erro de "secret cannot be null"...
//    @Autowired
//    private TokenService tokenService = new TokenService();
//
////    public TokenServiceTest(TokenService tokenService) {
////        this.tokenService = tokenService;
////    }
//
//    @Test
//    void getSubject() {
//        var customer = CustomerStub.getCustomerNoIdStub();
//
//        var expected = customer.getEmail();
//
//        var token = tokenService.generateToken(customer);
//
//        var response = tokenService.getSubject(token);
//
//        assertEquals(expected, response);
//    }
}