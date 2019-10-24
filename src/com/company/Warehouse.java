package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Warehouse{
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
    public ArrayList<Inventory> getWarehouse(){
        return invList;
    }

    public void sortByName(){
        CompareInventorybyName inv2 = new CompareInventorybyName();
        Collections.sort(invList,inv2);
    }
    public void sortbyNumber(){
        CompareInventorybyNumber inv2 = new CompareInventorybyNumber();
        Collections.sort(invList, inv2);
    }
}
