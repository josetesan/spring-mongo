package com.codetron.demo.jpa.entities.game;

import com.codetron.demo.jpa.entities.Game;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.DayOfWeek;

@Data
@NoArgsConstructor
public class Primitiva extends Game  {

    private DayOfWeek dayOfWeek;

    @Builder
    private Primitiva(String id, String name, BigDecimal price, BigDecimal prize, DayOfWeek dayOfWeek) {
        super(id, name, price, prize);
        this.dayOfWeek = dayOfWeek;
    }
}
