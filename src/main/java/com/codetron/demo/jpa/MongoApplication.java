package com.codetron.demo.jpa;

import com.codetron.demo.jpa.entities.Bet;
import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Game;
import com.codetron.demo.jpa.services.PlayDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.time.DayOfWeek;

@SpringBootApplication
@EnableSpringDataWebSupport
@EntityScan(basePackageClasses = { MongoApplication.class, Jsr310JpaConverters.class })
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

        this.playDrawService.reset();


        Customer customer = playDrawService.createCustomer();
        Game euromillions1 = playDrawService.createEuGame(DayOfWeek.TUESDAY);
        Game euromillions2 = playDrawService.createEuGame(DayOfWeek.FRIDAY);
        playDrawService.createDrawFor(euromillions1);
        playDrawService.createDrawFor(euromillions2);
        Game  primitiva1 = playDrawService.createPrimitivaGame(DayOfWeek.MONDAY);
        Game  primitiva2 = playDrawService.createPrimitivaGame(DayOfWeek.TUESDAY);
        Game  primitiva3 = playDrawService.createPrimitivaGame(DayOfWeek.WEDNESDAY);
        Game  primitiva4 = playDrawService.createPrimitivaGame(DayOfWeek.THURSDAY);
        Game  primitiva5 = playDrawService.createPrimitivaGame(DayOfWeek.SATURDAY);
        playDrawService.createDrawFor(primitiva1);
        playDrawService.createDrawFor(primitiva2);
        playDrawService.createDrawFor(primitiva3);
        playDrawService.createDrawFor(primitiva4);
        playDrawService.createDrawFor(primitiva5);

        final Bet bet10 = this.playDrawService.playEuromillonesGame(euromillions1,customer);
        final Bet bet11 = this.playDrawService.playEuromillonesGame(euromillions2,customer);
        final Bet bet20 = this.playDrawService.playPrimitivaGame(primitiva1,customer);
        final Bet bet21 = this.playDrawService.playPrimitivaGame(primitiva2,customer);
        final Bet bet22 = this.playDrawService.playPrimitivaGame(primitiva3,customer);
        final Bet bet23 = this.playDrawService.playPrimitivaGame(primitiva4,customer);
        final Bet bet24 = this.playDrawService.playPrimitivaGame(primitiva5,customer);

        this.playDrawService.createTicketFor(bet10,bet11, bet20,bet21,bet22,bet23,bet24);


    }

}
