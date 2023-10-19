package com.isadorastrottmann.apicrudcustomer.repository;

import com.isadorastrottmann.apicrudcustomer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    UserDetails findByEmail(String email);
}
