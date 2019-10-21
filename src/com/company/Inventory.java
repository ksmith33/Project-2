package com.company;


import java.util.Comparator;

public class Inventory {
    BikePart part;

    public Inventory(String name, int number){
        part = new BikePart(name, number);
    }

    public String findPart (){
        return part.getName();
    }
    public String toString(){
        return part.getName() + part.getNumber();
    }
    public Inventory getInventory(){
        return this;
    }


}
