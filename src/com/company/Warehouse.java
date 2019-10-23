package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Warehouse {
    ArrayList<Inventory> invList;

    public Warehouse(){
        invList = new ArrayList<>();
    }

    public void add(Inventory o){
        invList.add(o);
    }

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
    public ArrayList<Inventory> getWarehouse(){
        return invList;
    }

    public String sortByName(){
        CompareInventorybyName inv2 = new CompareInventorybyName();
        Collections.sort(invList,inv2);
        return invList.toString();
    }
    public String sortbyNumber(){
        CompareInventorybyNumber inv2 = new CompareInventorybyNumber();
        Collections.sort(invList, inv2);
        return invList.toString();
    }
}
