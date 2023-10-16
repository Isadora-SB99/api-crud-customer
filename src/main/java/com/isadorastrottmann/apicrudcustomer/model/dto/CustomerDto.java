package com.isadorastrottmann.apicrudcustomer.model.dto;

public record CustomerDto(
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