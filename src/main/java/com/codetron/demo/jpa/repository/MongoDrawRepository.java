package com.codetron.demo.jpa.repository;

import com.codetron.demo.jpa.entities.Draw;
import com.codetron.demo.jpa.entities.Game;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoDrawRepository extends MongoRepository<Draw,String>{

    Draw findByGame(final Game game);
}
