package com.codetron.demo.jpa;

import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Game;
import com.codetron.demo.jpa.services.PlayDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        Game game = playDrawService.createGame();
        playDrawService.createDrawFor(game);

        this.playDrawService.playEuromillonesGame(game,customer);

    }

}
