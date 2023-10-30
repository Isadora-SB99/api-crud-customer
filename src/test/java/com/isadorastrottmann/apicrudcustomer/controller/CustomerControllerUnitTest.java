package com.isadorastrottmann.apicrudcustomer.controller;

import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.service.CustomerService;
import com.isadorastrottmann.apicrudcustomer.stubs.CustomerStub;
import com.isadorastrottmann.apicrudcustomer.utils.CustomerUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldFindAllCustomers() throws Exception {
        var customer = CustomerStub.getCustomerStub();
        var customerList = Stream.of(customer).map(CustomerUtils::customerToDto).toList();

        when(customerService.getAll()).thenReturn((ResponseEntity<List<CustomerDto>>) customerList);
        this.mockMvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("isadora6@email.com")));
    }

//    @Test
//    void shouldFindCustomerById() throws Exception {
//        var customer = CustomerUtils.customerToDto(CustomerStub.getNewCustomerStub());
//
//        when(customerService.getOne(any())).thenReturn(customer);
//        this.mockMvc.perform(get("/customer/653f9fa7af5153218fc6aad4"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("isadoraTest@email.com")));
//
//    }


}