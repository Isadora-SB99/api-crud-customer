package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.stubs.CustomerDtoStub;
import com.isadorastrottmann.apicrudcustomer.stubs.CustomerStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest //cria o contexto da aplicação spring e injeta as dependencias
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void shouldInsertCustomer(){
        var expected = HttpStatusCode.valueOf(200);

        var customerDto = CustomerDtoStub.getRandomIdCustomerDtoSutb();
        var response = customerService.addCustomer(customerDto);

        assertEquals(expected, response.getStatusCode());
        assertEquals(customerDto.email(), response.getBody().email());
    }

    @Test
    void shouldNotInsertCustomerWithWrongPhoneFormat(){
        var customerDto = CustomerDtoStub.getWrongPhoneCustomerDtoSutb();

        assertThrows(RuntimeException.class, () -> customerService.addCustomer(customerDto));
    }

    @Test
    void shouldNotInsertCustomerWithInvalidBirthDate(){
        var customerDto = CustomerDtoStub.getInvalidBirthDateCustomerDtoSutb();

        assertThrows(RuntimeException.class, () -> customerService.addCustomer(customerDto));
    }

    @Test
    void shouldGetOneCustomer(){
        var expected = CustomerStub.getExistingCustomerStub();

        var response = customerService.getOne("653118b804b700754f509c8c").getBody().get();

        assertEquals(expected.getEmail(), response.email());
    }

    @Test
    void shouldNotGetCustomerThatDoesNotExist(){
        var expected = HttpStatusCode.valueOf(404);

        var response = customerService.getOne("1234").getStatusCode();

        assertEquals(expected, response);
    }

    @Test
    void shouldUpdateCustomer(){
        var customerDto = CustomerDtoStub.getRandomIdCustomerDtoSutb();
        var newCustomerDto = CustomerDtoStub.getRandomIdCustomerDtoSutb();
        var status = HttpStatusCode.valueOf(200);

        customerService.addCustomer(customerDto);

        var response = customerService.update(newCustomerDto, customerDto.id());

        assertEquals(status, response.getStatusCode());
        assertEquals(newCustomerDto.phoneNumber(), response.getBody().phoneNumber());
    }

    @Test
    void shouldRemoveCustomer(){
        var expected = HttpStatusCode.valueOf(204);

        var customerDto = CustomerDtoStub.getRandomIdCustomerDtoSutb();
        customerService.addCustomer(customerDto);

        var response = customerService.delete(customerDto.id()).getStatusCode();

        assertEquals(expected, response);
    }

    @Test
    void shouldNotRemoveCustomer(){
        var expected = HttpStatusCode.valueOf(404);

        var response = customerService.delete("12345").getStatusCode();

        assertEquals(expected, response);
    }
}