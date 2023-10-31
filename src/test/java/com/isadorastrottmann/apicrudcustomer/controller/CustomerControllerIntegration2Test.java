package com.isadorastrottmann.apicrudcustomer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadorastrottmann.apicrudcustomer.infra.security.TokenService;
import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegration2Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    // Create an ObjectMapper to convert the DTO to JSON
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TokenService tokenService;

    static Customer customer;

    @BeforeAll
    public static void start() {
        customer = new Customer.Builder()
                .id(new ObjectId().toString())
                .name("isadora test 4")
                .phoneNumber("51 91234 5678")
                .birthDate(LocalDateTime.of(1999,9,23, 0,0))
                .email("isadoraTest4@email.com")
                .password("123456")
                .build();
    }

    @AfterEach
    public void deleteCustomer() {
        customerRepository.delete(customer);
    }

    public HttpHeaders authorizationHeader() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        var customer = customerRepository.findById("652fe2877bb4a6422a0b5e6c").get();
        var token = tokenService.generateToken(customer);

        headers.add("Authorization", "Bearer " + token);
        return headers;
    }

    @Test
    void shouldPostCustomer() {
        CustomerDto dto = new CustomerDto(new ObjectId().toString(), "isadora test 3", "51 98765 4321", 1999, 9, 23, "isadoraTest3@email.com", "123456");

        System.out.println(dto);



        // Convert the DTO to JSON
        String jsonDto;// = objectMapper.writeValueAsString(dto);
        try {
            jsonDto = objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            // Handle the exception if needed
            e.printStackTrace();
            jsonDto = ""; // Set to an empty string in case of an error
        }

        System.out.println(jsonDto);


//        var httpEntity = new HttpEntity<>(dto);
//        var httpEntity = new HttpEntity<>(jsonDto);
        //não deveria precisar de autenticação pro cadastro...
        var httpEntity = new HttpEntity<>(jsonDto, authorizationHeader());

        System.out.println(httpEntity);

        var response = this.testRestTemplate
                .exchange("/customer", HttpMethod.POST, httpEntity, CustomerDto.class);

        System.out.println(response);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody().name(), "isadora test 3");
        assertEquals(Objects.requireNonNull(response.getBody()).name(), "isadora test 3");
    }

    @Test
    void shouldGetAllCustomers() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(authorizationHeader());
        System.out.println(httpEntity);

        var response = this.testRestTemplate
                .exchange("/customer", HttpMethod.GET, httpEntity, CustomerDto.class);
        System.out.println(response);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void shouldGetOneCustomer() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(authorizationHeader());

        var savedCustomer = this.customerRepository.save(customer);

        var response = this.testRestTemplate
                .exchange("/customer/" + savedCustomer.getId(), HttpMethod.GET, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().email(), "isadoraTest4@email.com");
    }

    @Test
    void shouldUpdateCustomer() throws JsonProcessingException {
        var savedCustomer = this.customerRepository.save(customer);

        CustomerDto dto = new CustomerDto(savedCustomer.getId(), "isadora test 3", "51 98765 4321", 1999, 9, 23, "isadoraTest3@email.com", "123456");

        String jsonDto = objectMapper.writeValueAsString(dto);

        var httpEntity = new HttpEntity<>(jsonDto, authorizationHeader());
//        var httpEntity = new HttpEntity<>(dto, authorizationHeader());

        var response = this.testRestTemplate
                .exchange("/customer/" + savedCustomer.getId(), HttpMethod.PUT, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().name(), "isadora test 3");
        assertEquals(response.getBody().email(), "isadoraTest3@email.com");

    }

    @Test
    void shouldDeleteCustomer() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(authorizationHeader());

        var savedCustomer = this.customerRepository.save(customer);

        var response = this.testRestTemplate
                .exchange("/customer/" + savedCustomer.getId(), HttpMethod.DELETE, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

    }


}
