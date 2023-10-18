package com.isadorastrottmann.apicrudcustomer.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.isadorastrottmann.apicrudcustomer.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    // gera o token jwt, com issuer, email do usuario e data de expiração
    public String generateToken(Customer customer) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API CRUD Customer")
                    .withSubject(customer.getEmail())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token JWT " + e);
        }
    }

    // recupera o usuario "dono" do token
    // o projeto de inspiração usa num security filter...
//    public String getSubject(String tokenJwt) {
//        try {
//            var algorithm = Algorithm.HMAC256(secret);
//            return JWT.require(algorithm)
//                    .withIssuer("API CRUD Customer")
//                    .build()
//                    .verify(tokenJwt)
//                    .getSubject();
//        } catch (JWTVerificationException e) {
//            throw new RuntimeException("Token JWT inválido ou expirado");
//        }
//    }

    // define a data de expiração do token pra 4 horas depois da hora em que for gerado
    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("-03:00"));
    }


}
