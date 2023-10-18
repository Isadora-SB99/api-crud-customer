package com.isadorastrottmann.apicrudcustomer.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "customers")
@Data
@AllArgsConstructor//(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Customer {
    @Id
    String id;
    String name;
    String phoneNumber;
    LocalDateTime birthDate;
    @Indexed(unique = true)
    String email;
    String password;

//    construtor de customer recebendo customer Builder
    private Customer(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.birthDate = builder.birthDate;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static class Builder {
        private String id;
        private String name;
        private String phoneNumber;
        private LocalDateTime birthDate;
        private String email;
        private String password;

        //cria um Builder com os metodos obrigatórios
//        public Builder() {
//        }

        //adiciona atributo opicional
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder birthDate(LocalDateTime birthDate) {
            this.birthDate = birthDate;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        //retorna o customer do construtor que recebe um Builder
        public Customer build() {
            return new Customer(this);
        }
    }

}
