package com.isadorastrottmann.apicrudcustomer.utils;

import com.isadorastrottmann.apicrudcustomer.stubs.CustomerDtoStub;
import com.isadorastrottmann.apicrudcustomer.stubs.CustomerStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerUtilsTest {

    @Test
    void shouldReturnCustomer() {
        var expected = CustomerStub.getCustomerNoIdStub();

        var response = CustomerUtils.dtoToCustomer(CustomerDtoStub.getNoIdCustomerDtoSutb());

        assertEquals(expected, response);
    }

    @Test
    void shouldReturnCustomerDto() {
        var expected = CustomerDtoStub.getNoIdCustomerDtoSutb();

        var response = CustomerUtils.customerToDto(CustomerStub.getCustomerNoIdStub());

        assertEquals(expected, response);
    }

    @Test
    void shouldReturnTrueForValidPhoneNumber(){
        var response = CustomerUtils.validatePhoneNumber(CustomerDtoStub.getRandomIdCustomerDtoSutb());

        assertTrue(response);
    }

    @Test
    void shouldReturnFalseForInvalidPhoneNumber(){
        var response = CustomerUtils.validatePhoneNumber(CustomerDtoStub.getWrongPhoneCustomerDtoSutb());

        assertFalse(response);
    }
}