package com.company;
import java.util.Comparator;

/**
 * This is a helper class to compare Inventory objects by name. It implements the Comparator interface.
 * This class satisfies the Project 2 requirements for CPSC 240-01.
 * @author Keshyra Smith, Kelly Donaghey, Olivia Duffy
 * @version 2019/11/01
 */
public class CompareInventorybyName implements Comparator<Inventory> {
    @Override
    public int compare(Inventory o1, Inventory o2) {
        return o1.getPartName().compareTo(o2.getPartName());
    }
}
