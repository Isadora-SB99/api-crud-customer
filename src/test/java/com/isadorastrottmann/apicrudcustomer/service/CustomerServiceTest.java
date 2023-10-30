package com.isadorastrottmann.apicrudcustomer.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    private CustomerService customerService;

//    void shouldReturnAlreadyExists(){
//        /*public ResponseEntity<CustomerDto> addCustomer(@Valid CustomerDto customerDto) {
//        var customer = CustomerUtils.dtoToCustomer(customerDto);
//        customer.setPassword(passwordEncoder.encode(customerDto.password()));
//        customerRepository.insert(customer);
//        var dto = CustomerUtils.customerToDto(customer);
//
//        return ResponseEntity.ok(dto);
//    }*/
//
//        var expected = ResponseEntity.badRequest();
//
//        var customerDto = CustomerUtils.customerToDto(CustomerStub.getCustomerStub());
//        var response = customerService.addCustomer(customerDto);
//
//    }

//    @Test
//    void getOneCustomer(){
////        var customerDto = CustomerUtils.customerToDto(CustomerStub.getCustomerStub());
////        ResponseEntity<Optional<CustomerDto>> expected = CustomerUtils.customerToDto(CustomerStub.getCustomerStub());
//
//        var expected = CustomerUtils.customerToDto(CustomerStub.getCustomerStub());
//
//        var response = customerService.getOne("653118b804b700754f509c8c").getBody().get();
//
//        assertEquals(expected, response);
//    }

}