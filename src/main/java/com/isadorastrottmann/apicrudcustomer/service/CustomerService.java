package com.isadorastrottmann.apicrudcustomer.service;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import com.isadorastrottmann.apicrudcustomer.utils.BirthDateUtils;
import com.isadorastrottmann.apicrudcustomer.utils.CustomerUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    BirthDateUtils birthDateUtils = new BirthDateUtils();
    CustomerUtils customerUtils = new CustomerUtils();

    public Customer addCustomer(CustomerDto customerDto){

        boolean validBirthDate = birthDateUtils.isValidBirthDate(birthDateUtils.mountBirthDate(customerDto.birthYear(), customerDto.birthMonth(), customerDto.birthDay()));

        //otimizar esse if
        if (!validBirthDate){
            throw new IllegalArgumentException();
        }
            return customerUtils.dtoToCustomer(customerDto);



    }
}
