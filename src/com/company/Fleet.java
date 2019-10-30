package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fleet {
    ArrayList<SalesVan> fleet;

    public Fleet (){
        fleet = new ArrayList<>();
    }

    public void add (SalesVan salesVan){
        fleet.add(salesVan);
    }

    public ArrayList<SalesVan> getVanList(){
        return fleet;
    }

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
    public int size(){
        return fleet.size();
    }
    public SalesVan get(int n){
        return fleet.get(n);
    }
}
