package com.codetron.demo.jpa.entities.bet;

import com.codetron.demo.jpa.entities.Bet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PrimitivaBet extends Bet {

    private List<Integer> numbers;
}
