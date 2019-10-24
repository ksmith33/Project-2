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

    public void move(Warehouse wH, SalesVan sV){
        wH.findInventorybyName().decrease();
        sV.findInventorybyName().increase();
    }

    public void move(SalesVan salesV, SalesVan salV){
        salesV.findInventorybyName().decrease();
        salV.findInventorybyName().increase();
    }

}
