package com.codetron.demo.jpa.controllers;

import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Order;
import com.codetron.demo.jpa.repository.MongoOrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by josete on 23/10/16.
 */
@RestController
@RequestMapping("/mongo")
public class OrderController {


    private MongoOrderRepository mongoOrderRepository;

    public OrderController(MongoOrderRepository mongoOrderRepository) {
        this.mongoOrderRepository = mongoOrderRepository;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> findAllTheOrders(@RequestParam(value = "size", required = false) final Integer size) {

        if (null != size) {
            Pageable pageable = new PageRequest(0,size);
            Page<Order> orders = this.mongoOrderRepository
                    .findAll(pageable);
            return orders.getContent();
        } else {
            return mongoOrderRepository
                    .findAll();
        }
    }

    @RequestMapping(value = "/orders/{customerId}", method = RequestMethod.GET)
    public List<Order> findAllTheOrdersOfAnUser(@PathVariable("customerId") final Customer customer) {

        return this.mongoOrderRepository.findByCustomer(customer);

    }


    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        final String id =
                this.mongoOrderRepository.save(order)
                .getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }



}
