package com.company;

import java.util.ArrayList;

public class SalesVan extends Warehouse {
    private Associate assoc;

    /*
     * Constructor for objects of class SalesVan.
     */
    public SalesVan(String name) {
        super(name);
        assoc = new Associate(super.getName());
    }

}