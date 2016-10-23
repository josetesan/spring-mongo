package com.codetron.demo.jpa.entities.bet;

import com.codetron.demo.jpa.entities.Bet;
import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Draw;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
public class EuromillionsBet extends Bet {

    private List<Integer> numeros;
    private List<Integer> estrellas;

    @Builder
    private EuromillionsBet(String id, Draw draw, Customer customer, Date datePlayed,
                            List<Integer> numeros,List<Integer> estrellas) {
        super(id, draw, customer, datePlayed);
        this.estrellas = estrellas;
        this.numeros = numeros;
    }


}
