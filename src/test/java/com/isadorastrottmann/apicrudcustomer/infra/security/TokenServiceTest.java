package com.isadorastrottmann.apicrudcustomer.infra.security;

import com.isadorastrottmann.apicrudcustomer.stubs.CustomerStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TokenServiceTest {

    @Autowired
    private TokenService tokenService;

    @Test
    void getSubject() {
        var customer = CustomerStub.getCustomerNoIdStub();

        var expected = customer.getEmail();

        var token = tokenService.generateToken(customer);

        var response = tokenService.getSubject(token);

        assertEquals(expected, response);
    }
}