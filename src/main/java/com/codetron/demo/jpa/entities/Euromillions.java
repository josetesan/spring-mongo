package com.codetron.demo.jpa.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Euromillions extends Game {


    private List<Integer> numeros;
    private List<Integer> estrellas;

    public Euromillions(){

    }

    public Euromillions(String name, BigDecimal price, Date drawingDate,
                        List<Integer> numeros, List<Integer> estrellas) {
        super(name, price, drawingDate);
        this.numeros = numeros;
        this.estrellas = estrellas;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public List<Integer> getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(List<Integer> estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Euromillions{");
        sb.append("numeros=").append(numeros);
        sb.append(", estrellas=").append(estrellas);
        sb.append('}');
        return sb.toString();
    }
}
