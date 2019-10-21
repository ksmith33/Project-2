package com.company;

public class BikePart {
    String name;
    int number;

    public BikePart(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return this.name;
    }
    public int getNumber(){
        return this.number;
    }
}
