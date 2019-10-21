package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Warehouse house = new Warehouse();
	Inventory inve = new Inventory("bike", 132);
	Inventory inve2 = new Inventory("handles", 456);
	Inventory inve3 = new Inventory("apples", 657);
	Scanner scnr = new Scanner(System.in);

	house.add(inve);
	house.add(inve2);
	house.add(inve3);

	String input = scnr.next();
    System.out.println(house.sort());

  }
}




