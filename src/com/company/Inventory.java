package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class satisfies the Project 1 requirements for CPSC 240.
 *
 * @author Kelly Donaghey, Olivia Duffy, Keshyra Smith
 * @version 2019/09/27
 */

public class Inventory extends BikePart{
    private int quantity;

    public Inventory(String name, int number, double price, double salesPrice, boolean onSale, int quantity){
        super(name, number,price,salesPrice,onSale);
        this.quantity = quantity;
    }

    public BikePart findPart(){
        return this;
    }

    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    public int getQuantity() {
        return this.quantity;
    }
}