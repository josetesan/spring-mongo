package com.codetron.demo.jpa.repository;

import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MongoOrderRepository extends MongoRepository<Order,String>{

    List<Order> findByCustomer(Customer customer);

}
