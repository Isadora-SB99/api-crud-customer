package com.isadorastrottmann.apicrudcustomer.repository;

import com.isadorastrottmann.apicrudcustomer.stubs.CustomerStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

//    @AfterEach
//    void deleteCustomer(){
//     customerRepository.delete(CustomerStub.getNewCustomerStub());
//    }

//    @Test
//    void shouldNotInsertUSerWithSameEmail() {
//        var customer = CustomerStub.getCustomerStub();
//        customerRepository.insert(customer);
//
//        Integer countCustomers = customerRepository.findAll().size();
//        assertEquals(1, countCustomers);
//    }

//    @Test
//    void shouldInsertUSer() {
//        var customer = CustomerStub.getNewCustomerStub();
//
//        Integer countCustomers = customerRepository.findAll().size();
//        assertEquals(5, countCustomers);
//    }

    @Test
    void shouldFindCustomerByEmail() {
        var customer = CustomerStub.getNewCustomerStub();

        var foundCustomer = customerRepository.findByEmail("isadoraTest@email.com");

        assertNotNull(foundCustomer);
        assertEquals(customer, foundCustomer);
    }

}