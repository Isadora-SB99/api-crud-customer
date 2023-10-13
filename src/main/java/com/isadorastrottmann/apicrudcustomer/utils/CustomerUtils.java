package com.isadorastrottmann.apicrudcustomer.utils;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;

public class CustomerUtils {

    public Customer dtoToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.id(),
                customerDto.name(),
                customerDto.phoneNumber(),
                customerDto.birthYear(),
                customerDto.birthMonth(),
                customerDto.birthDay(),
//                customerDto.birthDate(),
                customerDto.email(),
                customerDto.password()
        );
    }

    public CustomerDto customerToDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getPhoneNumber(),
                customer.getBirthYear(),
                customer.getBirthMonth(),
                customer.getBirthDay(),
//                customer.getBirthDate(),
                customer.getEmail(),
                customer.getPassword()
        );
    }
}
