package com.company;

import java.util.Comparator;

public class CompareInventorybyName implements Comparator<Inventory> {
    @Override
    public int compare(Inventory o1, Inventory o2) {
        return o1.getPartName().compareTo(o2.getPartName());
    }
}
