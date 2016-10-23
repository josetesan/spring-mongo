package com.codetron.demo.jpa.controllers;

import com.codetron.demo.jpa.entities.Game;
import com.codetron.demo.jpa.repository.MongoGameRepository;
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
public class GameController {


    private MongoGameRepository mongoGameRepository;



    public GameController(MongoGameRepository mongoGameRepository) {
        this.mongoGameRepository = mongoGameRepository;
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public List<Game> findAllTheGames(@RequestParam(value = "size", required = false) final Integer size) {

        if (null != size) {
            Pageable pageable = new PageRequest(0,size);
            Page<Game> games = this.mongoGameRepository
                    .findAll(pageable);
            return games.getContent();
        } else {
            return mongoGameRepository
                    .findAll();
        }
    }

    @RequestMapping(value = "/games", method = RequestMethod.POST)
    public ResponseEntity<String> createGame(@RequestBody Game game) {
        final String id =
                this.mongoGameRepository.save(game)
                .getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @RequestMapping(value="/game",method = RequestMethod.GET)
    public ResponseEntity<?> findGame(@RequestParam("name") final String name) {

        Game game = this.mongoGameRepository
                .findByName(name);

        return ResponseEntity.ok(game);

    }


}
