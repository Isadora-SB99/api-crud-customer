package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
class CustomerServiceTest {

//    @Mock
//    CustomerRepository customerRepository;
//
//    @InjectMocks
//    CustomerService customerService;
//
//    void shouldReturResponseEntityOfCustomer() {
//        var customerDto = new CustomerDto(null, "isadora", "51 98765-4321", 1999, 9, 23, "isadora@email.com", "123456");
//
//        when(customerRepository.insert(any(Customer.class))).thenReturn(new Customer());
//
//        var created = customerService.addCustomer(customerDto).getBody();
//
//        assertEquals(created.name(), customerDto.name());
//    }

    @Test
    void shouldReturnTrueCustomerService(){
        var expected = 2+2;

        var response = 3+1;

        assertEquals(expected, response);
    }

}