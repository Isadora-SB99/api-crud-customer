package com.isadorastrottmann.apicrudcustomer.model;

import com.isadorastrottmann.apicrudcustomer.stubs.CustomerStub;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void customerBuilderTest() {
        var stub = CustomerStub.getCustomerStub();

        var customer = new Customer.Builder()
                .id("653118b804b700754f509c8c")
                .name("isadora 6")
                .phoneNumber("51 97965-4231")
                .birthDate(LocalDateTime.of(1999, 9, 23, 00, 00))
                .email("isadora6@email.com")
                .password("123456")
                .build();

        assertEquals("isadora 6", customer.getName());
        assertEquals(stub, customer);
    }

}