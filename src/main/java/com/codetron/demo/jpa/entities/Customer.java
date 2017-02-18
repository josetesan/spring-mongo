package com.codetron.demo.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by josete on 23/10/16.
 */
@Document(collection = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer implements Serializable{

    @Id
    private String id;
    private String name;
    private String surname;
    private Integer age;


}
