package com.company;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Warehouse parts = new Warehouse("mainWarehouse");
        File inFile = new File("warehouseDB.txt");
        Scanner sc = new Scanner(inFile);
        String user = "filler";

        while (sc.hasNextLine()) {
            String newEntry = sc.next();
            String[] newObj = newEntry.split(",");
            String n = newObj[0];
            int id = Integer.parseInt(newObj[1]);
            double p = Double.parseDouble(newObj[2]);
            double sp = Double.parseDouble(newObj[3]);
            boolean s = Boolean.parseBoolean(newObj[4]);
            int q = Integer.parseInt(newObj[5]);
            Inventory newInv = new Inventory(n, id, p, sp, s, q);
            parts.add(newInv);
        }
        sc.close();

        Scanner input = new Scanner(System.in);

        while ((!user.equals("Quit")) && ((!user.equals("quit"))) && (!user.equals("QUIT"))) {

            {
                System.out.println("Please select your option from the following menu:");
                System.out.println("Read: Read an inventory delivery file");
                System.out.println("Enter: Enter a part");
                System.out.println("Sell: Sell a part");
                System.out.println("Display: Display a part");
                System.out.println("SortName: Sort parts by part name");
                System.out.println("SortNumber: Sort parts by part number");
                System.out.println("Quit:");
                System.out.println("Enter your choice: ");
                user = input.next();
            }

            if ((user.equals("Read")) || (user.equals("read")) || (user.equals("READ"))) {

                Boolean fileFound = false;

                while (!fileFound){
                    try {
                        System.out.println("Please enter the name of the delivery file: ");
                        String fileName = input.next();
                        if (fileName.equals("quit") || fileName.equals("Quit") || fileName.equals("QUIT")){
                            break;
                        }
                        File readFile = new File(fileName);
                        Scanner fileRead = new Scanner(readFile);
                        fileFound = true;

                        while (fileRead.hasNextLine()) {
                            String newEntry = fileRead.nextLine();
                            String[] newObj = newEntry.split(",");
                            String n = newObj[0];
                            int id = Integer.parseInt(newObj[1]);
                            double p = Double.parseDouble(newObj[2]);
                            double sp = Double.parseDouble(newObj[3]);
                            boolean s = Boolean.parseBoolean(newObj[4]);
                            int q = Integer.parseInt(newObj[5]);
                            Inventory newInv = new Inventory(n,id,p,sp,s,q);
                            Inventory listContains = parts.findInventorybyName(newInv.getPartName());
                            if (listContains == null) {
                                parts.add(newInv);
                            }
                            else{
                                listContains.setOnSale(newInv.isOnSale());
                                listContains.setQuantity(listContains.getQuantity() + newInv.getQuantity());
                                listContains.setPrice(newInv.getPrice());
                                listContains.setSalesPrice(newInv.getSalesPrice());
                            }
                        }
                        fileRead.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not Found.");
                    } catch (InputMismatchException e) {
                        System.out.println("There was an error reading the file.");
                    }
                }

            } else if ((user.equals("Enter")) || (user.equals("ENTER") || (user.equals("enter")))) {
                try {
                    System.out.println("Please enter the part name, part number, price, sales price, and if the item is on sale, and the quantity: ");
                    input.useDelimiter(",|\r|\n");
                    String partName = input.next();
                    int partNumber = input.nextInt();
                    double price = input.nextDouble();
                    double salesPrice = input.nextDouble();
                    boolean onSale = input.nextBoolean();
                    int quantity = input.nextInt();
                    Inventory newInv = new Inventory(partName, partNumber, price, salesPrice, onSale, quantity);
                    Inventory listContains = parts.findInventorybyName(newInv.getPartName());
                    if (listContains == null){
                        parts.add(newInv);
                    }
                    else{
                        listContains.setOnSale(newInv.isOnSale());
                        listContains.setQuantity(listContains.getQuantity() + newInv.getQuantity());
                        listContains.setPrice(newInv.getPrice());
                        listContains.setSalesPrice(newInv.getSalesPrice());
                    }
                }catch (InputMismatchException e){
                    System.out.println();
                    System.out.println("Sorry. There was a problem with your entry.");
                    System.out.println();
                    input.nextLine();
                }
            } else if ((user.equals("Sell") || (user.equals("sell") || (user.equals("SELL"))))) {
                try {
                    System.out.println("Enter the part number: ");
                    int number = input.nextInt();
                    Inventory newInv = parts.findInventorybyNumber(number);
                    if (newInv == null) {
                        System.out.println();
                        System.out.println("This item is not currently in stock.");
                        System.out.println();
                    }
                    else{
                        newInv.setQuantity(newInv.getQuantity() - 1);
                    }
                } catch (InputMismatchException e){
                    System.out.println();
                    System.out.println("Sorry. There was a problem with your entry.");
                    System.out.println();
                    input.nextLine();
                }
            } else if ((user.equals("Display") || user.equals("display"))) {
                try {
                    System.out.println("Enter the part name: ");
                    String partName = input.next();
                    Inventory newInv = parts.findInventorybyName(partName);
                    if (newInv == null) {
                        System.out.println();
                        System.out.println("This item is not currently in stock.");
                        System.out.println();
                    }
                    else{
                        if(newInv.isOnSale() == true){
                            System.out.println("Name: " + newInv.getPartName() + " " + "Price: " + newInv.getSalesPrice());
                        }
                        else{
                            System.out.println("Name: " + newInv.getPartName() + " " + "Price: " + newInv.getPrice());
                        }
                    }
                }catch (InputMismatchException e){
                    System.out.println();
                    System.out.println("Sorry. There was a problem with your entry.");
                    System.out.println();
                    input.nextLine();
                }
            } else if ((user.equals("SortName")) || (user.equals("sortname")) || (user.equals("SORTNAME"))) {
                parts.sortByName();
                ArrayList<Inventory> partsToSave = parts.getWarehouse();
                int counter = 0;
                while (counter < partsToSave.size()) {
                    System.out.println(partsToSave.get(counter));
                    ++counter;
                }
            } else if ((user.equals("SortNumber")) || (user.equals("sortnumber")) || (user.equals("SORTNUMBER"))) {
                parts.sortbyNumber();
                ArrayList<Inventory> partsToSave = parts.getWarehouse();
                int counter = 0;
                while (counter < partsToSave.size()) {
                    System.out.println(partsToSave.get(counter));
                    ++counter;
                }
            } else {
                if (!(user.equals("quit") || user.equals("Quit") || user.equals("QUIT"))) {
                    System.out.println();
                    System.out.println("Sorry. That's not a valid selection.");
                    System.out.println();
                    input.nextLine();
                }
            }
        }
        System.out.println();


        FileWriter fileWriter = new FileWriter("warehouseDB.txt", false);
        PrintWriter writer = new PrintWriter(fileWriter);
        ArrayList<Inventory> partsToSave = parts.getWarehouse();

        int counter = 0;
        while (counter < partsToSave.size() - 1) {
            writer.println(partsToSave.get(counter));
            ++counter;
        }
        while (counter < partsToSave.size()) {
            writer.print(partsToSave.get(counter));
            ++counter;
        }
        writer.close();
        input.close();
        System.out.println("Thank you. Goodbye.");
    }
}


