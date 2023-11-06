package com.isadorastrottmann.apicrudcustomer.stubs;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public class CustomerStub {

    public static Customer getExistingCustomerStub() {
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

    public static Customer getContractCustomerStub() {
        return new Customer.Builder()
                .id("6544eb3d73500c59611341c9")
                .name("isadora 9")
                .phoneNumber("51 98765-4321")
                .birthDate(LocalDateTime.of(1999, 9, 23, 00, 00))
                .email("isadora9@email.com")
                .password("123456")
                .build();
    }

    public static Customer getCustomerNoIdStub() {
        return new Customer.Builder()
                .id("")
                .name("isadora")
                .phoneNumber("51 987654321")
                .birthDate(LocalDateTime.of(1999, 9, 23, 0, 0))
                .email("isadora@email.com")
                .password("123456")
                .build();
    }

    public static Customer getRandomIdCustomer(){
        var id = new ObjectId().toString();
        return new Customer.Builder()
                .id(id)
                .name("isadora "+id)
                .phoneNumber("51 98765-4321")
                .birthDate(LocalDateTime.of(1999, 9, 23, 00, 00))
                .email("isadora"+id+"@email.com")
                .password("123456")
                .build();
    }


}
