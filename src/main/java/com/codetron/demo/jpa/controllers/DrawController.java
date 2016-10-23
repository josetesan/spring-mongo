package com.codetron.demo.jpa.controllers;

import com.codetron.demo.jpa.entities.Draw;
import com.codetron.demo.jpa.repository.MongoDrawRepository;
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
public class DrawController {


    private MongoDrawRepository mongoDrawRepository;

    public DrawController(MongoDrawRepository mongoDrawRepository) {
        this.mongoDrawRepository = mongoDrawRepository;
    }

    @RequestMapping(value = "/draws", method = RequestMethod.GET)
    public List<Draw> findAllTheGames(@RequestParam(value = "size", required = false) final Integer size) {

        if (null != size) {
            Pageable pageable = new PageRequest(0,size);
            Page<Draw> games = this.mongoDrawRepository
                    .findAll(pageable);
            return games.getContent();
        } else {
            return mongoDrawRepository
                    .findAll();
        }
    }

    @RequestMapping(value = "/draws", method = RequestMethod.POST)
    public ResponseEntity<String> createGame(@RequestBody Draw game) {
        final String id =
                this.mongoDrawRepository.save(game)
                .getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }



}
