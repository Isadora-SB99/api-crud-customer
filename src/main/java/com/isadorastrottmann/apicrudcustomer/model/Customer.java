package com.isadorastrottmann.apicrudcustomer.model;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    String id;
    String name;
    String phoneNumber;
//    Integer birthYear;
//    Integer birthMonth;
//    Integer birthDay;
    LocalDateTime birthDate;
    @Email
    String email;
    String password;
}
