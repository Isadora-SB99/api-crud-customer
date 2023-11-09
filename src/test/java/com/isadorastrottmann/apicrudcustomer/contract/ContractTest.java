package com.isadorastrottmann.apicrudcustomer.contract;

//import com.isadorastrottmann.apicrudcustomer.infra.security.TokenService;
//import com.isadorastrottmann.apicrudcustomer.repository.CustomerRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;

//import static io.restassured.RestAssured.given;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ContractTest {
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Test
//    void shouldCompareRsponseToExampleSchema() {
//        var customer = customerRepository.findById("652fe2877bb4a6422a0b5e6c").get();
//        log.info(() -> String.format("customer: "+customer));
//        var token = tokenService.generateToken(customer);
//        log.info(() -> String.format(token));
//
//        given()
//                .header("Authorization", "Bearer "+token)
//                .when().get("http://localhost:8080/customer")
//                .then().statusCode(200)
//                .body(matchesJsonSchemaInClasspath("schemaExample.json"));
//    }
}
