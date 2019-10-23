package com.company;

import java.util.ArrayList;

/**
 * This class aggregates Inventory class objects. It instantiates with an ArrayList and reads in the "current" inventory from an
 * associated text file.
 * Things to contemplate: instantiate with a method for creating a file? Or is the file supplied by the user when creating a
 * Warehouse?
 * Warehouse will need an identifier. Best way: either a number or a string.
 * The main warehouse will need to have its information automatically fed into the program when it starts.
 *
 */

public class Warehouse {
    private String name;
    private ArrayList<Inventory> invlist;

    /**
     * Constructor for objects of class Warehouse.
     */
    public Warehouse(String name){
        this.name = name;
       invlist = new ArrayList<>();
    }

    /**
     * This method adds Inventory objects to the Warehouse Arraylist.
     * @param inv - the Inventory object to add to the Arraylist.
     */
    public void add(Inventory inv){
        invlist.add(inv);
    }

    /**
     * This method returns the Warehouse name.
     * @param wH - the Warehouse object
     * @return the name of the object in the form of a String.
     */
    public String getName(Warehouse wH){
        return this.name;
    }

    /**
     * This method retrieves the Inventory object from the Warehouse ArrayList at the specified index.
     * @param n - the index of the object to return.
     * @return the Inventory object at the nth index of the list.
     */
    public Inventory get(int n){
      return invlist.get(n);
    }

    /**
     * This method checks to see if the Inventory object is present in the Warehouse ArrayList.
     * @param inv - the object whose presence is being looked for
     * @return returns true if the object is present in the list.
     */
    public boolean contains(Inventory inv){
        return invlist.contains(inv);
    }
}
