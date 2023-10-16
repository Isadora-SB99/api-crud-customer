package com.isadorastrottmann.apicrudcustomer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    String id;
    String name;
    String phoneNumber;
    Integer birthYear;
    Integer birthMonth;
    Integer birthDay;
    //        LocalDateTime birthDate;
    String email;
    String password;
}
