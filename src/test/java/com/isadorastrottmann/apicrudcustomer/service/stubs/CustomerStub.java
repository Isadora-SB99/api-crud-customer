package com.isadorastrottmann.apicrudcustomer.service.stubs;

import com.isadorastrottmann.apicrudcustomer.model.Customer;

import java.time.LocalDateTime;

public class CustomerStub {

    public static Customer getCustomerStub() {
        /*
        "id": "653118b804b700754f509c8c",
        "name": "isadora 6",
        "phoneNumber": "51 97965-4231",
        "birthYear": 1999,
        "birthMonth": 9,
        "birthDay": 23,
        "email": "isadora6@email.com",
        "password": "$2a$10$S2kG6U61wYHZ/SW580GOTe23xlrNp8BFHCkIzXT.aFaHw8aGpJuV."
        */
        return new Customer.Builder()
                .id("653118b804b700754f509c8c")
                .name("isadora 6")
                .phoneNumber("51 97965-4231")
                .birthDate(LocalDateTime.of(1999, 9, 23, 00, 00))
                .email("isadora6@email.com")
                .password("123456")
                .build();
    }

    public static Customer getNewCustomerStub() {
        return new Customer.Builder()
                .id("653f9fa7af5153218fc6aad4")
                .name("isadora test")
                .phoneNumber("51 97965-4231")
                .birthDate(LocalDateTime.of(1999, 9, 23, 00, 00))
                .email("isadoraTest@email.com")
                .password("123456")
                .build();
    }


}