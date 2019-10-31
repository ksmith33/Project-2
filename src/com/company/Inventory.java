package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class creates Inventory objects by extending BikePart and adding a quantity field.
 * It satisfies the Project 2 requirements for CPSC 240-01.
 * @author Keshyra Smith, Kelly Donaghey, Olivia Duffy
 * @version 2019/11/01
 */

public class Inventory extends BikePart{
    private int quantity;

    /**
     * Constructor for objects of the Inventory class.
     * @param name Name of the object as a String.
     * @param number ID number as an int.
     * @param price Price as a double.
     * @param salesPrice salesPrice as a double.
     * @param onSale boolean
     * @param quantity int
     */
    public Inventory(String name, int number, double price, double salesPrice, boolean onSale, int quantity){
        super(name, number,price,salesPrice,onSale);
        this.quantity = quantity;
    }

    /**
     * This method changes the quantity of an Inventory object.
     * @param newQuantity the new value in the form of an int.
     */
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    /**
     * This method decreases the quantity of an Inventory object.
     * @param n an int
     */
    public void decrease(int n){
        quantity = quantity - n;
    }

    /**
     * This method increases the quantity of an Inventory object.
     * @param n the amount by which to increase the quantity.
     */
    public void increase(int n){
        quantity = quantity + n;
    }

    /**
     * This method returns the quantity of an Inventory object.
     * @return an int
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * This method overrides the "toString" method.
     * @return a String.
     */
    @Override
    public String toString(){
        return String.format("%s%s%d%s%.2f%s%.2f%s%b%s%d",super.getPartName() ,",",super.getPartNum() ,",",super.getPrice(),",",super.getSalesPrice(),",",super.isOnSale(), "," , quantity);
    }
}