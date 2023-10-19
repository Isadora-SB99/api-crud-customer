package com.isadorastrottmann.apicrudcustomer.controller;

import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customer Controller")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @Operation(summary = "Post Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer Saved Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public @ResponseBody ResponseEntity<CustomerDto> postCustomer(
            @RequestBody @Valid CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    @GetMapping
    @Operation(summary = "Get All Customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer List Retrieved Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Customer List Was Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get One Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer Retrieved Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Customer Was Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Optional<CustomerDto>> getOneCustomer(@PathVariable String id) {
        return customerService.getOne(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Put Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer Updated Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Customer Was Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody @Valid CustomerDto customerDto, @PathVariable String id) {
        return customerService.update(customerDto, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Customer Deleted Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Customer Was Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        return customerService.delete(id);
    }

}
