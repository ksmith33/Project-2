package com.company;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;

public class Associate {
    private String name;

    /**
     * This is the constructor for objects of class Associate. An instance of this class is created with every instance of the SalesVan class.
     * The object takes its name from the SalesVan name.
     * @param name
     */
    public Associate(String name){
        this.name = name;
    }

    public void move(Warehouse wH, Warehouse sV, String part, int quantity){
        int index = wH.findInventorybyName(part);
        wH.get(index).decrease(quantity);
        int indexToMove = sV.findInventorybyName(part);
        if (indexToMove == -1){
            sV.add(wH.get(index));
        }
        else{
            sV.get(index).increase(quantity);
        }
    }

    public void move(SalesVan salesV, SalesVan salV, String part, int quantity){
        int index = salesV.findInventorybyName(part);
        salesV.get(index).decrease(quantity);
        int indexToMove = salV.findInventorybyName(part);
        if (indexToMove == -1){
            salV.add(salesV.get(index));
        }
        else{
            salV.get(index).increase(quantity);
        }
    }

}
