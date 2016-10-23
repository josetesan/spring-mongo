package com.codetron.demo.jpa.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Document(collection = "games")
public class Game implements Serializable{

    @Id
    private String id;
    @Indexed
    private String name;
    private BigDecimal price;
    @Indexed
    private Date drawingDate;

    public Game() {
    }

    public Game(String name, BigDecimal price, Date drawingDate) {
        this.name = name;
        this.price = price;
        this.drawingDate = drawingDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDrawingDate() {
        return drawingDate;
    }

    public void setDrawingDate(Date drawingDate) {
        this.drawingDate = drawingDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Game{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", drawingDate=").append(drawingDate);
        sb.append('}');
        return sb.toString();
    }
}
