package com.codetron.demo.jpa.repository;

import com.codetron.demo.jpa.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MongoCustomerRepository extends MongoRepository<Customer,String>{

    List<Customer> findByName(final String name);
}
