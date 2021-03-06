package com.codetron.demo.jpa.repository;

import com.codetron.demo.jpa.entities.Game;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoGameRepository extends MongoRepository<Game,String>{

    Game findByName(final String name);
}
