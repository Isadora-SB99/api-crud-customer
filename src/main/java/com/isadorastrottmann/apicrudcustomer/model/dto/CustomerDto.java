package com.isadorastrottmann.apicrudcustomer.model.dto;

import java.time.LocalDateTime;

public record CustomerDto (
        String id,
        String name,
        String phoneNumber,
        Integer birthYear,
        Integer birthMonth,
        Integer birthDay,
//        LocalDateTime birthDate,
        String email,
        String password
) {
}
