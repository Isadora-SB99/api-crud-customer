package com.isadorastrottmann.apicrudcustomer.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerDto(
        @JsonProperty("id")
        String id,

        @JsonProperty("name")
        @NotNull(message = "Nome não pode estar vazio")
        String name,

        @JsonProperty("phoneNumber")
        @Pattern(regexp = "^(\\+55\\s)?\\(?(?:[1-9]{2})\\)?\\s?\\d{4,5}-?\\d{4}$",
                message = "Formato de número de telefone inválido")
        String phoneNumber,

        @JsonProperty("birthYear")
        @NotNull(message = "Ano do nascimento não pode estar vazio")
        Integer birthYear,

        @JsonProperty("birthMonth")
        @NotNull(message = "Mês do nascimento não pode estar vazio")
        Integer birthMonth,

        @JsonProperty("birthDay")
        @NotNull(message = "Dia do nascimento não pode estar vazio")
        Integer birthDay,

        @JsonProperty("email")
        @NotNull(message = "Email não pode estar vazio")
        @Email
        String email,

        @JsonProperty("password")
        @NotNull(message = "Senha não pode estar vazia")
        String password
) {
}