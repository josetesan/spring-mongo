package com.codetron.demo.jpa;

import com.codetron.demo.jpa.repository.MongoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    @Autowired
    private MongoGameRepository mongoGameRepository;



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

        /*
        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        List<Integer> estrellas = Arrays.asList(3,12);

        this.mongoGameRepository.deleteAll();

        long now = System.currentTimeMillis();
        for (int i=0;i<100_000;i++) {
            this.mongoGameRepository.save(new Euromillions("Euromillones", BigDecimal.TEN, new Date(), numeros, estrellas));
            this.mongoGameRepository.save(new Game("Quiniela", BigDecimal.ONE, new Date()));
            this.mongoGameRepository.save(new Game("Primitiva", BigDecimal.TEN, new Date()));
        }
        long later = System.currentTimeMillis();
        System.out.printf("Took %d.2f seconds", (later-now/1000d));
        */
    }

}
