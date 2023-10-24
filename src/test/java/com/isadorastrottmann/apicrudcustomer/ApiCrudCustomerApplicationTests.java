package com.isadorastrottmann.apicrudcustomer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiCrudCustomerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnTrue(){
        var expected = 2+2;

        var response = 3+1;

        assertEquals(expected, response);
    }

}
