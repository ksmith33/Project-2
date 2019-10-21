package com.company;

import java.util.ArrayList;
import java.util.Collections;


public class Warehouse{
    ArrayList<Inventory> inv;

    public Warehouse(){
        inv = new ArrayList<>();
    }

    public void add(Inventory o){
        inv.add(o);
    }

   private Inventory findInventory(String name){
        int counter = 0;
        boolean found = false;

        while (counter < inv.size() && found == false){
            if (inv.get(counter).findPart().equals(name) ){
                found = true;
            }
            else{
                ++counter;
            }
        }
        Inventory inv2 = inv.get(counter).getInventory();
        return inv2;
    }

    public String sort(){
        CompareInventory inv2 = new CompareInventory();
        Collections.sort(inv,inv2);
        return inv.toString();
    }


}
