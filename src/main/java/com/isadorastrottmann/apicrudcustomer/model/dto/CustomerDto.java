package com.isadorastrottmann.apicrudcustomer.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerDto(
        String id,
        @NotNull(message = "Nome não pode estar vazio")
        String name,
        @Pattern(regexp = "^(\\+55\\s)?\\(?(?:[1-9]{2})\\)?\\s?\\d{4,5}-?\\d{4}$",
                message = "Formato de número de telefone inválido")
        String phoneNumber,
        @NotNull(message = "Ano do nascimento não pode estar vazio")
        Integer birthYear,
        @NotNull(message = "Mês do nascimento não pode estar vazio")
        Integer birthMonth,
        @NotNull(message = "Dia do nascimento não pode estar vazio")
        Integer birthDay,
        @NotNull(message = "Email não pode estar vazio")
        @Email
        String email, //validar unique
        @NotNull(message = "Senha não pode estar vazia")
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