package com.company;

import java.util.ArrayList;

public class Fleet {
    ArrayList<SalesVan> fleet;

    public Fleet (){
        fleet = new ArrayList<>();
    }

    public void add (SalesVan salesVan){
        fleet.add(salesVan);
    }

    public SalesVan findSalesVane (String name){
        int counter = 0;
        boolean found = false;
        SalesVan van = null;

        while (counter < fleet.size() && found == false){
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
}
