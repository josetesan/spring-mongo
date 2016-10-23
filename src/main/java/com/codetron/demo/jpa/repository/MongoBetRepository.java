package com.codetron.demo.jpa.repository;

import com.codetron.demo.jpa.entities.Bet;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoBetRepository extends MongoRepository<Bet,String>{

}
