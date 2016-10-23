package com.codetron.demo.jpa.services;

import com.codetron.demo.jpa.entities.Bet;
import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Draw;
import com.codetron.demo.jpa.entities.Game;
import com.codetron.demo.jpa.entities.bet.EuromillionsBet;
import com.codetron.demo.jpa.entities.game.Euromillions;
import com.codetron.demo.jpa.repository.MongoBetRepository;
import com.codetron.demo.jpa.repository.MongoCustomerRepository;
import com.codetron.demo.jpa.repository.MongoDrawRepository;
import com.codetron.demo.jpa.repository.MongoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by josete on 23/10/16.
 */
public class PlayDrawService {

    private MongoBetRepository mongoBetRepository;
    private MongoCustomerRepository mongoCustomerRepository;
    private MongoDrawRepository mongoDrawRepository;
    private MongoGameRepository mongoGameRepository;

    @Autowired
    public PlayDrawService(MongoBetRepository mongoBetRepository,
                           MongoCustomerRepository mongoCustomerRepository,
                           MongoDrawRepository mongoDrawRepository,
                           MongoGameRepository mongoGameRepository) {
        this.mongoBetRepository = mongoBetRepository;
        this.mongoCustomerRepository = mongoCustomerRepository;
        this.mongoDrawRepository = mongoDrawRepository;
        this.mongoGameRepository = mongoGameRepository;
    }


    public Customer createCustomer() {

        Random random = new Random(23122313L);

        Customer customer =
                Customer.builder()
                .age(random.nextInt(100))
                .name(UUID.randomUUID().toString())
                .surname(UUID.randomUUID().toString())
                .build();

        return mongoCustomerRepository.save(customer);
    }


    public Game createGame() {

        Euromillions euromillions =
                Euromillions
                .builder()
                .build();

        return mongoGameRepository.save(euromillions);


    }


    public Bet playEuromillonesGame(final Game game, final Customer customer) {


        Draw draw = mongoDrawRepository.findByGame(game);

        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        List<Integer> estrellas = Arrays.asList(3,12);

        EuromillionsBet euromillionsBet = EuromillionsBet.builder()
                .customer(customer)
                .draw(draw)
                .datePlayed(new Date())
                .estrellas(estrellas)
                .numeros(numeros)
                .build();

        return mongoBetRepository.save(euromillionsBet);




    }

    public Draw createDrawFor(Game game) {

        Draw draw = Draw.builder()
                .game(game)
                .drawingDate(new Date())
                .build();

        return mongoDrawRepository.save(draw);

    }
}
