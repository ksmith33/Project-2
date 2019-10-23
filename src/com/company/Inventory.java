package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class satisfies the Project 1 requirements for CPSC 240.
 *
 * @author Kelly Donaghey, Olivia Duffy, Keshyra Smith
 * @version 2019/09/27
 */

public class Inventory {
    private BikePart part;
    private int quantity;

    public Inventory(String name, int number, double price, double salesPrice, boolean onSale, int quantity){
        part = new BikePart(name, number,price,salesPrice,onSale);
        this.quantity = quantity;
    }

    public String findPartName (){
        return part.getPartName();
    }
    public Integer findPartNumber (){
        return part.getPartNum();
    }
    public String toString(){
        return part.toString();
    }
    public BikePart findPart(){
        return part;
    }
    public Inventory getInventory(){
        return this;
    }
    public void setQuantity(int newQuantity){
        quantity = quantity + newQuantity;
    }

    public int getQuantity() {
        return this.quantity;
    }
}