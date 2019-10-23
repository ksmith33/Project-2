package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Things to contemplate: instantiate with a method for creating a file? Or is the file supplied by the user when creating a
 * Warehouse?
 * Warehouse will need an identifier. Best way: either a number or a string.
 * The main warehouse will need to have its name instantiated in main().
 */

/**
 * This class aggregates Inventory class objects. It instantiates with an ArrayList and reads in the "current" inventory from an
 * associated text file. It also has a name for identification purposes.
 */

public class Warehouse {
    private String name;
    ArrayList<Inventory> invList;

    /*
     * Constructor for objects of class Warehouse.
     */
    public Warehouse(String name){
        this.name = name;
        invList = new ArrayList<>();
    }

    /**
     * This method adds Inventory objects to the Warehouse Arraylist.
     * @param inv - the Inventory object to add to the Arraylist.
     */
    public void add(Inventory inv){
        invList.add(inv);
    }

    /**
     * This method searches for an Inventory object by its name.
     * @param name - the name of the object to find
     * @return the Inventory object name.
     */
    public Inventory findInventorybyName(String name){
        int counter = 0;
        boolean found = false;

        while (counter < invList.size() && found == false){
            if (invList.get(counter).findPartName().equals(name) ){
                found = true;

            }
            else{
                ++counter;
            }
        }
        return invList.get(counter);
    }

    /**
     * This method searches for an Inventory object by its number.
     * @param number - the number of the object to find
     * @return the Inventory object
     */
    public Inventory findInventorybyNumber (int number){
        int counter = 0;
        boolean found = false;

        while (counter < invList.size() && found == false){
            if (invList.get(counter).findPartNumber() == number){
                found = true;

            }
            else{
                ++counter;
            }
        }
        return invList.get(counter);
    }

    /**
     * This method returns just the ArrayList of the Warehouse object.
     * @return the ArrayList
     */
    public ArrayList<Inventory> getList(){
        return invList;
    }

    /**
     * This method sorts the Warehouse ArrayList by Inventory object name.
     * @return a list sorted alphabetically.
     */
    public String sortByName(){
        CompareInventorybyName inv2 = new CompareInventorybyName();
        Collections.sort(invList,inv2);
        return invList.toString();
    }

    /**
     * This method sorts the Warehouse ArrayList by Inventory object number.
     * @return a list sorted numerically.
     */
    public String sortbyNumber(){
        CompareInventorybyNumber inv2 = new CompareInventorybyNumber();
        Collections.sort(invList, inv2);
        return invList.toString();
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
        return invList.get(n);
    }

    /**
     * This method checks to see if the Inventory object is present in the Warehouse ArrayList.
     * @param inv - the object whose presence is being looked for
     * @return returns true if the object is present in the list.
     */
    public boolean contains(Inventory inv){
        return invList.contains(inv);
    }
}





