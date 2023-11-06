package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.stubs.CustomerDtoStub;
import com.isadorastrottmann.apicrudcustomer.stubs.CustomerStub;
import com.isadorastrottmann.apicrudcustomer.utils.CustomerUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

//    @InjectMocks
//    private CustomerService customerService;
//
//// reclmando do encoder null
//    @Test
//    void shouldInsertCustomer(){
//        var expected = HttpStatusCode.valueOf(200);
//
//        var customerDto = CustomerDtoStub.getRandomIdCustomerDtoSutb();
//        var response = customerService.addCustomer(customerDto);
//
//        assertEquals(expected, response.getStatusCode());
//    }

/*    @Test
    void getOneCustomer(){
//        var customerDto = CustomerUtils.customerToDto(CustomerStub.getCustomerStub());
//        ResponseEntity<Optional<CustomerDto>> expected = CustomerUtils.customerToDto(CustomerStub.getCustomerStub());

        var expected = CustomerUtils.customerToDto(CustomerStub.getCustomerStub());

        var response = customerService.getOne("653118b804b700754f509c8c").getBody().get();

        assertEquals(expected, response);
    }*/
}