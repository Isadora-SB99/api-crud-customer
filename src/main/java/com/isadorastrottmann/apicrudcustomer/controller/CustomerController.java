package com.isadorastrottmann.apicrudcustomer.controller;

import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public @ResponseBody ResponseEntity<CustomerDto> postCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerDto>> getOneCustomer(@PathVariable String id) {
        return customerService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody @Valid CustomerDto customerDto, @PathVariable String id) {
        return customerService.update(customerDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        return customerService.delete(id);
    }

}
