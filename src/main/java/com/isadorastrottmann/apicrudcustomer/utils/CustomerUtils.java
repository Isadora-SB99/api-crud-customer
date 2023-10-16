package com.isadorastrottmann.apicrudcustomer.utils;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerUtils {

    public static Customer dtoToCustomer(CustomerDto customerDto) {

        LocalDateTime birthDate = BirthDateUtils.mountBirthDate(
                customerDto.birthYear(),
                customerDto.birthMonth(),
                customerDto.birthDay());

        boolean isvalidBirthDate = BirthDateUtils.isValidBirthDate(birthDate);

        if (!isvalidBirthDate) {
            throw new IllegalArgumentException("Data de aniversário inválida");
        }

        return new Customer(
                customerDto.id(),
                customerDto.name(),
                customerDto.phoneNumber(),
                birthDate,
                customerDto.email(),
                customerDto.password()
        );
    }

    public static CustomerDto customerToDto(Customer customer) {
        List<Integer> birthDate = BirthDateUtils.
                separateBirthDate(customer.getBirthDate());

        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getPhoneNumber(),
                birthDate.get(0),
                birthDate.get(1),
                birthDate.get(2),
                customer.getEmail(),
                customer.getPassword()
        );
    }
}
