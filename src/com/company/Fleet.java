package com.company;

/**
 * This class aggregates SalesVan objects. It satisfies the Project 2 requirements for CPSC 240-01.
 * @author Keshyra Smith, Kelly Donaghey, Olivia Duffy
 * @version 2019/11/01
 */

import java.util.ArrayList;

public class Fleet {
    ArrayList<SalesVan> fleet;

    /**
     * Constructor for objects of class Fleet.
     */
    public Fleet (){
        fleet = new ArrayList<>();
    }

    /**
     * This method adds a SalesVan object to a Fleet object's ArrayList.
     * @param salesVan The SalesVan object to be added.
     */
    public void add (SalesVan salesVan){
        fleet.add(salesVan);
    }

    /**
     * This method returns the ArrayList of a Fleet object.
     * @return ArrayList<SalesVan>
     */
    public ArrayList<SalesVan> getVanList(){
        return fleet;
    }

    /**
     * This method searches for a SalesVan object in the Fleet ArrayList.
     * @param name - The name of the SalesVan object to return. Takes the form of a String.
     * @return the SalesVan object.
     */
    public SalesVan findSalesVane (String name){
        int counter = 0;
        boolean found = false;
        SalesVan van = null;

        while (counter <= fleet.size()-1 && found == false){
            if (fleet.get(counter).getName().equals(name) ){
                found = true;
                van = fleet.get(counter);
            }
            else{
                ++counter;
            }
        }
        return van;
    }

    /**
     * This method returns the Fleet ArrayList size in the form of an int.
     * @return an int.
     */
    public int size(){
        return fleet.size();
    }

    /**
     * This method returns a SalesVan object given its index in a Fleet ArrayList.
     * @param n the index of the SalesVan object.
     * @return the SalesVan object.
     */
    public SalesVan get(int n){
        return fleet.get(n);
    }
}
