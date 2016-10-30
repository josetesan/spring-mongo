package com.codetron.demo.jpa;

import com.codetron.demo.jpa.entities.Bet;
import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Game;
import com.codetron.demo.jpa.entities.Ticket;
import com.codetron.demo.jpa.services.PlayDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {


    @Autowired
    private PlayDrawService playDrawService;




    public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        Customer customer = playDrawService.createCustomer();
        Game euromillions = playDrawService.createEuGame();
        playDrawService.createDrawFor(euromillions);
        Game  primitiva = playDrawService.createPrimitivaGame();
        playDrawService.createDrawFor(primitiva);

        final Bet bet1 = this.playDrawService.playEuromillonesGame(euromillions,customer);
        final Bet bet2 = this.playDrawService.playPrimitivaGame(primitiva,customer);

        this.playDrawService.createTicketFor(bet1,bet2);


    }

}
