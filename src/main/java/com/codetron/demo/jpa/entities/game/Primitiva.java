package com.codetron.demo.jpa.entities.game;

import com.codetron.demo.jpa.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Primitiva extends Game  {

    @Builder
    private Primitiva(String id, String name, BigDecimal price, BigDecimal prize) {
        super(id, name, price, prize);
    }
}
