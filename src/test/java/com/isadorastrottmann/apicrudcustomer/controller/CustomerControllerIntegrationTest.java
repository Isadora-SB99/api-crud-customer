package com.isadorastrottmann.apicrudcustomer.controller;

import com.isadorastrottmann.apicrudcustomer.infra.security.TokenService;
import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //executa os testes como classe, não como metodo. "O JUnit 5 cria uma instância da classe para cada teste, com isso, a anotação é necessária para poder manter um estado da classe"
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //roda os testes em uma porta aleatória pra não gerar conflito caso a aplicaçao já esteja rodando
//@SpringBootTest //deu erro/problema com o TestRestTemplate (?)
public class CustomerControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TokenService tokenService;

    Customer customer;

    //@TODO pesquisar sobre o TestRestTemplate

    @BeforeAll
    public void start() {
        this.customer = new Customer.Builder()
                .email("isadoraTest2@email.com")
                .password("123456")
                .build();
    }

    public HttpHeaders authorizationHeader() {
        HttpHeaders headers = new HttpHeaders();

        var customer = customerRepository.findById("652fe2877bb4a6422a0b5e6c").get();
        var token = tokenService.generateToken(customer);

        headers.add("Authorization", "Bearer " + token);
        return headers;
    }

    @AfterEach
    public void deleteCustomer() {
        customerRepository.delete(this.customer);
    }

    @Test
    void shouldPostCustomer() {
        CustomerDto dto = new CustomerDto(null, "isadora test 3", "51 98765 4321", 1999, 9, 23, "isadoraTest3@email.com", "123456");

        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(dto);

        var response = this.testRestTemplate
                .exchange("/customer", HttpMethod.POST, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody().name(), "isadora test 3");
        assertEquals(Objects.requireNonNull(response.getBody()).name(), "isadora test 3");
    }

    @Test
    void shouldGetAllCustomers() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(authorizationHeader());


        var response = this.testRestTemplate
                .exchange("/customer", HttpMethod.GET, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void shouldGetOneCustomer() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(authorizationHeader());

        var savedCustomer = this.customerRepository.save(this.customer);

        var response = this.testRestTemplate
                .exchange("/customer/" + savedCustomer.getId(), HttpMethod.GET, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().email(), "isadoraTest2@email.com");
    }

    @Test
    void shouldUpdateCustomer() {
        var savedCustomer = this.customerRepository.save(this.customer);

        CustomerDto dto = new CustomerDto(null, "isadora test 3", "51 98765 4321", 1999, 9, 23, "isadoraTest3@email.com", "123456");

        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(dto, authorizationHeader());

        var response = this.testRestTemplate
                .exchange("/customer/" + savedCustomer.getId(), HttpMethod.PUT, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().name(), "isadora test 3");
        assertEquals(response.getBody().email(), "isadoraTest3@email.com");

    }

    @Test
    void shouldDeleteCustomer() {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(authorizationHeader());

        var savedCustomer = this.customerRepository.save(this.customer);

        var response = this.testRestTemplate
                .exchange("/customer/" + savedCustomer.getId(), HttpMethod.DELETE, httpEntity, CustomerDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

    }


}
