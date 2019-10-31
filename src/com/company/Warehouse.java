package com.company;

/**
 * This class creates a Warehouse object to store Inventory objects
 * It satisfies the Project 2 requirements for CPSC 240-01.
 * @author Keshyra Smith, Kelly Donaghey, Olivia Duffy
 * @version 2019/11/01
 */

import java.util.ArrayList;
import java.util.Collections;

public class Warehouse{
    private String name;
    private ArrayList<Inventory> invList;

    /*
     * Constructor for objects of class Warehouse.
     */
    public Warehouse(String name){
        invList = new ArrayList<>();
        this.name = name;
    }

    /**
     * This method adds Inventory objects to the Warehouse Arraylist.
     * @param inv - the Inventory object to add to the Arraylist.
     */
    public void add(Inventory inv){
        invList.add(inv);
    }
    public void updateInventory(Inventory inv, int index){
        invList.get(index).setPrice(inv.getPrice());
        invList.get(index).setSalesPrice(inv.getSalesPrice());
        invList.get(index).increase(inv.getQuantity());
        invList.get(index).setOnSale(inv.isOnSale());
    }

    /**
     * This method searches for an Inventory object by its name.
     * @param name - the name of the object to find
     * @return the Inventory object name.
     */
    public int findInventorybyName(String name){
        int counter = 0;
        boolean found = false;
        int index = -1;

        while (counter <= invList.size()-1 && found == false){
            if (invList.get(counter).getPartName().equals(name) ){
                index = counter;
                found = true;
            }
            else{
                ++counter;
            }
        }
        return index;
    }

    /**
     * This method searches for an Inventory object by its number.
     * @param number - the number of the object to find
     * @return the Inventory object
     */
    public int findInventorybyNumber (int number){
        int counter = 0;
        boolean found = false;
        int index = -1;

        while (counter <= invList.size()-1 && found == false){
            if (invList.get(counter).getPartNum() == number){
                index = counter;
                found = true;


            }
            else{
                ++counter;
            }
        }
        return index;
    }

    /**
     * This method returns just the ArrayList of the Warehouse object.
     * @return the ArrayList
     */
    public Warehouse getWarehouse(){
        return this;
    }

    public ArrayList<Inventory> getInvList() {
        return invList;
    }

    public void setInvList(ArrayList<Inventory> invList) {
        this.invList = invList;
    }

    /**
     * This method sorts the Warehouse ArrayList by Inventory object name.
     */
    public void sortByName(){
        CompareInventorybyName inv2 = new CompareInventorybyName();
        Collections.sort(invList,inv2);
    }
    /**
     * This method sorts the Warehouse ArrayList by Inventory object number.
     * @return a list sorted numerically.
     */
    public void sortbyNumber(){
        CompareInventorybyNumber inv2 = new CompareInventorybyNumber();
        Collections.sort(invList, inv2);
    }

    /**
     * This method returns the Warehouse name.
     * @return the name of the object in the form of a String.
     */
    public String getName(){
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
     * This method returns the size of the Warehouse ArrayList.
     * @return the size of the Warehouse ArrayList as an int.
     */
    public int size(){
        return invList.size();
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





