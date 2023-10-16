package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.repository.CustomerRepository;
import com.isadorastrottmann.apicrudcustomer.utils.BirthDateUtils;
import com.isadorastrottmann.apicrudcustomer.utils.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
//    BirthDateUtils birthDateUtils = new BirthDateUtils();
//    CustomerUtils customerUtils = new CustomerUtils();

    @Autowired
    private CustomerRepository customerRepository;

    //recebendo um dto e convertendo pra customer pra salvar
    public Customer addCustomer(CustomerDto customerDto) {

        //duplicação de codigo, converte também no customerUtils...
        LocalDateTime birthDate = BirthDateUtils.mountBirthDate(customerDto.birthYear(), customerDto.birthMonth(), customerDto.birthDay());

        boolean validBirthDate = BirthDateUtils.isValidBirthDate(birthDate);

        //otimizar esse if
        if (!validBirthDate) {
            throw new IllegalArgumentException();
        }
        return CustomerUtils.dtoToCustomer(customerDto);

    }

    public List<CustomerDto> getAll(){
        return customerRepository.findAll()
                .stream()
                .map(CustomerUtils::customerToDto)
                .toList();
    }

    public Optional<CustomerDto> getOne(String id){
        return customerRepository.findById(id)
                .map(CustomerUtils::customerToDto);
    }


}
