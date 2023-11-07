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

        boolean isValidDate = BirthDateUtils.validateBirthDate(birthDate);
        boolean isValidPhoneNumber = CustomerUtils.validatePhoneNumber(customerDto);

        if (!isValidDate) {
            throw new RuntimeException("Data de aniversário inválida");
        }

        if (!isValidPhoneNumber) {
            throw new RuntimeException("Formato de número de telefone inválido");
        }

        return new Customer.Builder()
                .id(customerDto.id())
                .name(customerDto.name())
                .phoneNumber(customerDto.phoneNumber())
                .birthDate(birthDate)
                .email(customerDto.email())
                .password(customerDto.password())
                .build();
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

    public static boolean validatePhoneNumber(CustomerDto customerDto) {
        var phoneNumber = customerDto.phoneNumber();

        return phoneNumber.matches("^(\\+55\\s)?\\(?[1-9]{2}\\)?\\s?9?\\d{4}-?\\d{4}$");
    }
}
