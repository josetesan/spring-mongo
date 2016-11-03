package com.codetron.demo.jpa.repository;

import com.codetron.demo.jpa.entities.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoTicketRepository extends MongoRepository<Ticket,String>{

}
