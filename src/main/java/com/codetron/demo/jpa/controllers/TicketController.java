package com.codetron.demo.jpa.controllers;

import com.codetron.demo.jpa.entities.Ticket;
import com.codetron.demo.jpa.repository.MongoTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by josete on 23/10/16.
 */
@RestController
@RequestMapping("/mongo")
public class TicketController {


    private MongoTicketRepository mongoTicketRepository;

    @Autowired
    public TicketController(MongoTicketRepository mongoTicketRepository) {
        this.mongoTicketRepository = mongoTicketRepository;
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> findAllTheGames(@RequestParam(value = "size", required = false) final Integer size) {

        if (null != size) {
            Pageable pageable = new PageRequest(0,size);
            Page<Ticket> games = this.mongoTicketRepository
                    .findAll(pageable);
            return games.getContent();
        } else {
            return mongoTicketRepository
                    .findAll();
        }
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public ResponseEntity<String> createTicket(@RequestBody Ticket ticket) {
        final String id =
                this.mongoTicketRepository.save(ticket)
                .getId();

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }



}
