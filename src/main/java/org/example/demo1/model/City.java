package org.example.demo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "khong duoc trong")
    private String nameCity;
    @NotBlank(message = "khong duoc trong")
    private String nameCountry;
    @Min(value = 0, message = "phai lon hon 0")
    private Long square;
    @Min(value = 0, message = "phai lon hon 0")
    private int population;
    @Min(value = 0, message = "phai lon hon 0")
    private Long GDP;
    private String description;


    public City(){}

    public City(Long id, String nameCity, String nameCountry, Long square, int population, Long GDP, String description) {
        this.id = id;
        this.nameCity = nameCity;
        this.nameCountry = nameCountry;
        this.square = square;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public Long getSquare() {
        return square;
    }

    public void setSquare(Long square) {
        this.square = square;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

