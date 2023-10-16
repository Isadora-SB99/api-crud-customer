package com.isadorastrottmann.apicrudcustomer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record CustomerDto (
        String id,
        String name,
        String phoneNumber,
        Integer birthYear,
        Integer birthMonth,
        Integer birthDay,
        String email,
        String password
) {
}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class CustomerDto {
//        String id;
//        String name;
//        String phoneNumber;
//        Integer birthYear;
//        Integer birthMonth;
//        Integer birthDay;
//        String email;
//        String password;
//}