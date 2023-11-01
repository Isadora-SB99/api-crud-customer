package com.isadorastrottmann.apicrudcustomer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadorastrottmann.apicrudcustomer.infra.security.TokenService;
import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TokenService tokenService;

    static Customer customer;

    static HttpHeaders headers = new HttpHeaders();


    @BeforeAll
    public static void start() {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("accept", "application/json");

        customer = new Customer.Builder()
                .id(new ObjectId().toString())
                .name("isadora test 4")
                .phoneNumber("51 91234-5678")
                .birthDate(LocalDateTime.of(1999, 9, 23, 0, 0))
                .email("isadoraTest4@email.com")
                .password("123456")
                .build();
    }

    @AfterEach
    public void deleteCustomer() {
        customerRepository.delete(customer);
    }

    public HttpHeaders addAuthorizationHeader() {
        var customer = customerRepository.findById("652fe2877bb4a6422a0b5e6c").get();
        var token = tokenService.generateToken(customer);

        headers.add("Authorization", "Bearer " + token);
        return headers;
    }

    @Test
    void shouldPostCustomer() throws JsonProcessingException {
        var id = new ObjectId().toString();
        CustomerDto dto = new CustomerDto(
                id,
                "isadora test " + id,
                "51 98765-4321",
                1999,
                9,
                23,
                "isadoraTest" + id + "@email.com",
                "123456");

        var jsonDto = objectMapper.writeValueAsString(dto); //formata o objeto recebido em json e converte pra string

        var httpEntity = new HttpEntity<>(jsonDto, headers);

        var response = this.testRestTemplate.postForEntity("/customer", httpEntity, String.class);
        var jsonBody = response.getBody();
        var customerResponseJson = objectMapper.readTree(jsonBody);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(customerResponseJson.path("name").asText(), "isadora test " + id);
    }

    @Test
    void shouldGetAllCustomers() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(addAuthorizationHeader());

        var response = this.testRestTemplate
                .exchange("/customer",
                        HttpMethod.GET,
                        httpEntity,
                        new ParameterizedTypeReference<List<CustomerDto>>() {
                        });//https://www.appsdeveloperblog.com/get-list-of-objects-with-testresttemplate/

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void shouldGetOneCustomer() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(addAuthorizationHeader());

        var savedCustomer = this.customerRepository.save(customer);

        var response = this.testRestTemplate
                .exchange("/customer/" + savedCustomer.getId(), HttpMethod.GET, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(Objects.requireNonNull(response.getBody()).email(), "isadoraTest4@email.com");
    }

    @Test
    void shouldUpdateCustomer() throws JsonProcessingException {
        var savedCustomer = this.customerRepository.save(customer);

        CustomerDto dto = new CustomerDto(
                savedCustomer.getId(),
                "isadora test 3",
                "51 98765-4321",
                1999,
                9,
                23,
                "isadoraTest3@email.com",
                "123456");

        String jsonDto = objectMapper.writeValueAsString(dto);

        var httpEntity = new HttpEntity<>(jsonDto, addAuthorizationHeader());

        var response = this.testRestTemplate.exchange("/customer/" + savedCustomer.getId(), HttpMethod.PUT, httpEntity, String.class);
        var jsonBody = response.getBody();
        JsonNode customerResponseJson = objectMapper.readTree(jsonBody);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(customerResponseJson.path("name").asText(), "isadora test 3");
        assertEquals(customerResponseJson.path("email").asText(), "isadoraTest3@email.com");
    }

    @Test
    void shouldDeleteCustomer() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(addAuthorizationHeader());

        var savedCustomer = this.customerRepository.save(customer);

        var response = this.testRestTemplate
                .exchange("/customer/" + savedCustomer.getId(), HttpMethod.DELETE, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}