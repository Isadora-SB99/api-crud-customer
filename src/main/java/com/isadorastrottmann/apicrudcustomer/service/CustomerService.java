package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.repository.CustomerRepository;
import com.isadorastrottmann.apicrudcustomer.utils.CustomerUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<CustomerDto> addCustomer(@Valid CustomerDto customerDto) {
        // @TODO retorno pode ser de erro, se tiver alguma informação faltando... ???
        var customer = CustomerUtils.dtoToCustomer(customerDto);
        // @TODO trocar criptografia de lugar (colocar no utils)
        customer.setPassword(passwordEncoder.encode(customerDto.password()));
        customerRepository.insert(customer);
        var dto = CustomerUtils.customerToDto(customer);

        return ResponseEntity.ok(dto);
    }

    public ResponseEntity<List<CustomerDto>> getAll() {
        var customerList = customerRepository
                .findAll()
                .stream()
                .map(CustomerUtils::customerToDto)
                .toList();

        return customerList.isEmpty() ?
                ResponseEntity.notFound().build()
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

        if (customerOptional.isEmpty()) {
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
