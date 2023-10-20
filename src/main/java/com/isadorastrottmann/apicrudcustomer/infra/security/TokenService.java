package com.isadorastrottmann.apicrudcustomer.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
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
    public String getSubject(String tokenJwt) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API CRUD Customer")
                    .build()
                    .verify(tokenJwt)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token JWT inválido ou expirado");
        }
    }

    // define a data de expiração do token pra 15 minutos depois da hora em que for gerado
    private Instant expirationDate() {
//        return LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00"));
        // @TODO voltar pra 15 minutos
        return LocalDateTime.now().plusHours(6).toInstant(ZoneOffset.of("-03:00"));
    }
}
