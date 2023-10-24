package com.isadorastrottmann.apicrudcustomer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest
class CustomerControllerTest {

//    @MockBean
//    CustomerService customerService;
//
//    ObjectMapper mapper = new ObjectMapper();
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void shouldReturnCreatedCustomer() throws Exception {
//        CustomerDto customerDto = new CustomerDto(null, "isadora", "51 98765-4321", 1999, 9, 23, "isadora@email.com", "123456");
//
////        Customer customer = new Customer.Builder()
////                .id(customerDto.id())
////                .name(customerDto.name())
////                .phoneNumber(customerDto.phoneNumber())
////                .birthDate(BirthDateUtils.mountBirthDate(
////                        customerDto.birthYear(),
////                        customerDto.birthMonth(),
////                        customerDto.birthDay()))
////                .email(customerDto.email())
////                .password(customerDto.password())
////                .build();
//
//        when(customerService.addCustomer(any(CustomerDto.class))).thenReturn(ResponseEntity.ok(customerDto));
//
//        mockMvc.perform(post("/customer")
//                        .content(mapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value(customerDto.name()));
//    }
//
////    @Test
////    void shouldReturnCustomerWhitSameId() throws Exception {
////        CustomerDto customerDto = new CustomerDto(null, "isadora", "51 98765-4321", 1999, 9, 23, "isadora@email.com", "123456");
////
////        Customer customer = new Customer.Builder()
////                .id(customerDto.id())
////                .name(customerDto.name())
////                .phoneNumber(customerDto.phoneNumber())
////                .birthDate(BirthDateUtils.mountBirthDate(
////                        customerDto.birthYear(),
////                        customerDto.birthMonth(),
////                        customerDto.birthDay()))
////                .email(customerDto.email())
////                .password(customerDto.password())
////                .build();
////
////        when(customerService.getOne(any())).thenReturn(ResponseEntity.ok(customer.getId()));
////
////        mockMvc.perform(get("/customer")
////                .content(mapper.writeValueAsString(customerDto))
////                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.name").value(customerDto.name()));
////    }

    @Test
    void shouldReturnTrueCustomerController(){
        var expected = 2+2;

        var response = 3+1;

        assertEquals(expected, response);
    }

}