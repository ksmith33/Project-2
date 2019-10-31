package com.company;

/**
 * This class moves inventory from one Warehouse or SalesVan object to another.
 * It satisfies the Project 2 requirements for CPSC 240-01.
 * @author Keshyra Smith, Kelly Donaghey, Olivia Duffy
 * @version 2019/11/01
 */

public class Associate {
    private String name;

    /**
     * This is the constructor for objects of class Associate.
     */
    public Associate(String name){
        this.name = name;
    }

    /**
     * This method allows an Associate object to move inventory from warehouse to sales van.
     * @param wH The Warehouse object that has the inventory.
     * @param sV The SalesVan object to receive the inventory.
     * @param part The part that will be moved.
     * @param quantity The quantity of parts moved.
     */
    public void move(Warehouse wH, Warehouse sV, String part, int quantity){
        int index = wH.findInventorybyName(part);
        wH.get(index).decrease(quantity);
        int indexToMove = sV.findInventorybyName(part);
        if (indexToMove == -1){
            Inventory Inv = new Inventory(wH.get(index).getPartName(), wH.get(index).getPartNum(),wH.get(index).getPrice(),wH.get(index).getSalesPrice(),wH.get(index).isOnSale(), quantity);
            sV.add(Inv);
        }
        else{
            sV.get(indexToMove).increase(quantity);
        }
    }

    /**
     * This method allows an Associate object to move inventory from sales van to sales van.
     * @param salesV The SalesVan object that has the inventory.
     * @param salV The SalesVan object to receive the inventory.
     * @param part The part that will be moved.
     * @param quantity The quantity of parts moved.
     */
    public void move(SalesVan salesV, SalesVan salV, String part, int quantity){
        int index = salesV.findInventorybyName(part);
        salesV.get(index).decrease(quantity);
        int indexToMove = salV.findInventorybyName(part);
        if (indexToMove == -1){
            Inventory Inv = new Inventory(salesV.get(index).getPartName(), salesV.get(index).getPartNum(),salesV.get(index).getPrice(),salesV.get(index).getSalesPrice(),salesV.get(index).isOnSale(), quantity);
            salV.add(Inv);
        }
        else{
            salV.get(indexToMove).increase(quantity);
        }
    }

}
