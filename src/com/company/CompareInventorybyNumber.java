package com.company;

import java.util.Comparator;

public class CompareInventorybyNumber implements Comparator <Inventory> {

    @Override
    public int compare(Inventory o1, Inventory o2) {
        return o1.findPartNumber().compareTo(o2.findPartNumber());
    }
}
