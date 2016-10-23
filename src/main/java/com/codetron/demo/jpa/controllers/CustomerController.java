package com.codetron.demo.jpa.controllers;

import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.repository.MongoCustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class CustomerController {


    private MongoCustomerRepository mongoCustomerRepository;


    public CustomerController(MongoCustomerRepository mongoCustomerRepository) {
        this.mongoCustomerRepository = mongoCustomerRepository;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> findAllTheGames(@RequestParam(value = "size", required = false) final Integer size) {

        if (null != size) {
            Pageable pageable = new PageRequest(0,size);
            Page<Customer> list = this.mongoCustomerRepository
                    .findAll(pageable);
            return list.getContent();
        } else {
            return mongoCustomerRepository
                    .findAll();
        }
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<String> createGame(@RequestBody Customer customer) {
        final String id =
                this.mongoCustomerRepository.save(customer)
                .getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @RequestMapping(value="/customer",method = RequestMethod.GET)
    public ResponseEntity<?> findGame(@RequestParam("name") final String name) {

        List<Customer> list = this.mongoCustomerRepository
                .findByName(name);

        return ResponseEntity.ok(list);

    }


}
