package com.codetron.demo.jpa.services;

import com.codetron.demo.jpa.entities.Bet;
import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Draw;
import com.codetron.demo.jpa.entities.Game;
import com.codetron.demo.jpa.entities.Ticket;
import com.codetron.demo.jpa.entities.bet.EuromillionsBet;
import com.codetron.demo.jpa.entities.bet.PrimitivaBet;
import com.codetron.demo.jpa.entities.game.Euromillions;
import com.codetron.demo.jpa.entities.game.Primitiva;
import com.codetron.demo.jpa.repository.MongoBetRepository;
import com.codetron.demo.jpa.repository.MongoCustomerRepository;
import com.codetron.demo.jpa.repository.MongoDrawRepository;
import com.codetron.demo.jpa.repository.MongoGameRepository;
import com.codetron.demo.jpa.repository.MongoTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PlayDrawService {

    private MongoBetRepository mongoBetRepository;
    private MongoCustomerRepository mongoCustomerRepository;
    private MongoDrawRepository mongoDrawRepository;
    private MongoGameRepository mongoGameRepository;
    private MongoTicketRepository mongoTicketRepository;


    @Autowired
    public PlayDrawService(MongoBetRepository mongoBetRepository,
                           MongoCustomerRepository mongoCustomerRepository,
                           MongoDrawRepository mongoDrawRepository,
                           MongoGameRepository mongoGameRepository,
                           MongoTicketRepository mongoTicketRepository) {
        this.mongoBetRepository = mongoBetRepository;
        this.mongoCustomerRepository = mongoCustomerRepository;
        this.mongoDrawRepository = mongoDrawRepository;
        this.mongoGameRepository = mongoGameRepository;
        this.mongoTicketRepository = mongoTicketRepository;
    }


    public void reset() {

        this.mongoGameRepository.deleteAll();
        this.mongoBetRepository.deleteAll();
        this.mongoCustomerRepository.deleteAll();
        this.mongoDrawRepository.deleteAll();
        this.mongoTicketRepository.deleteAll();

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


    public Game createEuGame(final DayOfWeek dayOfWeek) {

        final Euromillions euromillones =
                Euromillions
                .builder()
                        .name("Euromillones")
                        .price(BigDecimal.TEN)
                        .prize(new BigDecimal(17_000_000L))
                        .dayOfWeek(dayOfWeek)
                .build();

         return mongoGameRepository.save(euromillones);

    }

    public Game createPrimitivaGame(final DayOfWeek dayOfWeek) {

        Primitiva primitiva =
                Primitiva.builder()
                        .name("Primitiva")
                        .price(BigDecimal.ONE)
                        .prize(new BigDecimal(1_000_000L))
                        .dayOfWeek(dayOfWeek)
                    .build();

        return mongoGameRepository.save(primitiva);
    }


    public Bet playEuromillonesGame(final Game game, final Customer customer) {


        Draw draw = mongoDrawRepository.findByGame(game);

        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        List<Integer> estrellas = Arrays.asList(3,12);

        EuromillionsBet euromillionsBet = EuromillionsBet.builder()
                .customer(customer)
                .draw(draw)
                .datePlayed(ZonedDateTime.now().toLocalDateTime())
                .estrellas(estrellas)
                .numeros(numeros)
                .build();

        return mongoBetRepository.save(euromillionsBet);


    }


    public Bet playPrimitivaGame(final Game game, final Customer customer) {

        Draw draw = mongoDrawRepository.findByGame(game);

        List<Integer> numeros = Arrays.asList(1,2,3,4,5);

        PrimitivaBet primitivaBet = PrimitivaBet.builder()
                .customer(customer)
                .draw(draw)
                .datePlayed(ZonedDateTime.now().toLocalDateTime())
                .numeros(numeros)
                .build();

        return mongoBetRepository.save(primitivaBet);

    }

    public Draw createDrawFor(Game game) {

        Draw draw = Draw.builder()
                .game(game)
                .drawingDate(ZonedDateTime.now().toLocalDateTime())
                .build();

        return mongoDrawRepository.save(draw);

    }

    public Ticket createTicketFor(Bet ... bets) {

        Ticket ticket = Ticket.builder()
                .dateCreated(ZonedDateTime.now().toLocalDateTime())
                .bets(Arrays.asList(bets))
                .build();

        return this.mongoTicketRepository.save(ticket);

    }
}
