package com.codetron.demo.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "bets")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bet implements Serializable {


    @Id
    private String id;

    @DBRef
    private Draw draw;

    @DBRef
    private Customer customer;

    private Date datePlayed;


}
