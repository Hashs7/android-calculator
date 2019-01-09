package com.gmail.pro.glagouy.example.modeles;

public class Planet {
    private String name;
    private String description;

    public Planet(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
