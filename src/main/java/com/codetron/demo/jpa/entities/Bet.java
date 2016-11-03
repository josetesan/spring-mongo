package com.codetron.demo.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Document(collection = "bets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Bet implements Serializable {


    @Id
    private String id;

    @DBRef
    @Indexed
    private Draw draw;

    @DBRef
    @Indexed
    private Customer customer;
    private LocalDateTime datePlayed;

}
