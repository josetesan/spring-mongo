package com.codetron.demo.jpa.entities.bet;

import com.codetron.demo.jpa.entities.Bet;
import com.codetron.demo.jpa.entities.Customer;
import com.codetron.demo.jpa.entities.Draw;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class PrimitivaBet extends Bet {

    private List<Integer> numeros;

    @Builder
    private PrimitivaBet(String id, Draw draw, Customer customer, LocalDateTime datePlayed, List<Integer> numeros) {
        super(id, draw, customer, datePlayed);
        this.numeros = numeros;
    }
}
