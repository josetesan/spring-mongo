package com.codetron.demo.jpa.controllers;

import com.codetron.demo.jpa.entities.Bet;
import com.codetron.demo.jpa.repository.MongoBetRepository;
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
public class BetController {


    private MongoBetRepository mongoBetRepository;

    public BetController(MongoBetRepository mongoBetRepository) {
        this.mongoBetRepository = mongoBetRepository;
    }

    @RequestMapping(value = "/bets", method = RequestMethod.GET)
    public List<Bet> findAllTheGames(@RequestParam(value = "size", required = false) final Integer size) {

        if (null != size) {
            Pageable pageable = new PageRequest(0,size);
            Page<Bet> games = this.mongoBetRepository
                    .findAll(pageable);
            return games.getContent();
        } else {
            return mongoBetRepository
                    .findAll();
        }
    }

    @RequestMapping(value = "/bets", method = RequestMethod.POST)
    public ResponseEntity<String> createGame(@RequestBody Bet bet) {
        final String id =
                this.mongoBetRepository.save(bet)
                .getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }



}
