package com.codetron.demo.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket implements Serializable {

    @Id
    private String id;

    private List<Bet> bets;

    private LocalDateTime dateCreated;
}
