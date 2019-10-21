package com.company;

import java.util.Comparator;

public class CompareInventory implements Comparator<Inventory> {

    @Override
    public int compare(Inventory o1, Inventory o2) {
       return o1.findPart().compareTo(o2.findPart());
    }
}
