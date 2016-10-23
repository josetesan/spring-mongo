package com.codetron.demo.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;


@Document(collection = "games")
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Game implements Serializable{

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal price;
    private BigDecimal prize;

}
