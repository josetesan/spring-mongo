package com.codetron.demo.jpa.repository;

import com.codetron.demo.jpa.entities.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MongoGameRepository extends MongoRepository<Game,String>{

    List<Game> findByName(final String name);
}
