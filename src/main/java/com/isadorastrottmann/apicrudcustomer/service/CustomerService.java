package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.repository.CustomerRepository;
import com.isadorastrottmann.apicrudcustomer.utils.BirthDateUtils;
import com.isadorastrottmann.apicrudcustomer.utils.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<CustomerDto> addCustomer(CustomerDto customerDto) {
        //pode dar illegal argument... TRATAR
        var customer = CustomerUtils.dtoToCustomer(customerDto);
        customerRepository.insert(customer);
        var customerToDto = CustomerUtils.customerToDto(customer);

        return ResponseEntity.ok(customerToDto);
    }

    public ResponseEntity<List<CustomerDto>> getAll() {
        var customerList = customerRepository
                .findAll()
                .stream()
                .map(CustomerUtils::customerToDto)
                .toList();

        return customerList.isEmpty() ?
                ResponseEntity.noContent().build()
                : ResponseEntity.ok(customerList);
    }

    public ResponseEntity<Optional<CustomerDto>> getOne(String id) {
        var customer = customerRepository
                .findById(id)
                .map(CustomerUtils::customerToDto);

        return customer.isEmpty() ?
                ResponseEntity.notFound().build()
                : ResponseEntity.ok(customer);
    }

    public ResponseEntity<CustomerDto> update(CustomerDto customerDto, String id) {
//        var customer = customerRepository.findById(id)
//                .flatMap(c -> customerDto.map(CustomerUtils::dtoToCustomer)
//                        .doOnNext(e -> e.setId(id)))
//                .flatMap(customerRepository::save)
//                .map(CustomerUtils::customerToDto);

        var customerOptional = customerRepository.findById(id);

        if (customerOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            var customer = CustomerUtils.dtoToCustomer(customerDto);
            customer.setId(id);
            customerRepository.save(customer);
            var customerToDto = CustomerUtils.customerToDto(customer);
            return ResponseEntity.ok(customerToDto);
        }
    }

    public ResponseEntity<Void> delete(String id) {
        var customer = customerRepository.findById(id);

        if (customer.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            customerRepository.delete(customer.get());
            return ResponseEntity.noContent().build();
        }
    }


}
