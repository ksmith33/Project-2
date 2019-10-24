package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Warehouse {
    private String name;
    private ArrayList<Inventory> invList;

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
        Inventory inv = null;

        while (counter < invList.size()-1 && found == false){
            if (invList.get(counter).getPartName().equals(name) ){
                found = true;
                inv = invList.get(counter);
            }
            else{
                ++counter;
            }
        }
        return inv;
    }

    /**
     * This method searches for an Inventory object by its number.
     * @param number - the number of the object to find
     * @return the Inventory object
     */
    public Inventory findInventorybyNumber (int number){
        int counter = 0;
        boolean found = false;
        Inventory inv = null;

        while (counter < invList.size() && found == false){
            if (invList.get(counter).getPartNum() == number){
                found = true;
                inv = invList.get(counter);

            }
            else{
                ++counter;
            }
        }
        return inv;
    }

    /**
     * This method returns just the ArrayList of the Warehouse object.
     * @return the ArrayList
     */
    public ArrayList<Inventory> getWarehouse(){
        return invList;
    }

    /**
     * This method sorts the Warehouse ArrayList by Inventory object name.
     * @return a list sorted alphabetically.
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





