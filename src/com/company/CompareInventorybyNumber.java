package com.company;
import java.util.Comparator;

/**
 * This class is a helper class that sorts Inventory objects by number. It implements the Comparator interface.
 * This class satisfies the Project 2 requirements for CPSC 240-01.
 * @author Keshyra Smith, Kelly Donaghey, Olivia Duffy
 * @version 2019/11/01
 */
public class CompareInventorybyNumber implements Comparator <Inventory> {

    @Override
    public int compare(Inventory o1, Inventory o2) {
        return o1.getPartNum().compareTo(o2.getPartNum());
    }
}
