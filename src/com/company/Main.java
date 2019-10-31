package com.company;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Warehouse parts = new Warehouse("mainWarehouse");
        Associate mainAss = new Associate(parts.getName());
        Fleet mainFleet = new Fleet();

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
                System.out.println("Move: Move inventory");
                System.out.println("Add: Add a SalesVan to Fleet");
                System.out.println("Quit:");
                System.out.println("Enter your choice: ");
                user = input.next();
            }

            if ((user.equals("Read")) || (user.equals("read")) || (user.equals("READ"))) {

                try {
                    System.out.println("Please enter the name of the delivery file: ");
                    String fileName = input.next();
                    if (fileName.equals("quit") || fileName.equals("Quit") || fileName.equals("QUIT")) {
                        break;
                    }
                    File readFile = new File(fileName);
                    Scanner fileRead = new Scanner(readFile);

                    while (fileRead.hasNextLine()) {
                        String newEntry = fileRead.nextLine();
                        String[] newObj = newEntry.split(",");
                        String n = newObj[0];
                        int id = Integer.parseInt(newObj[1]);
                        double p = Double.parseDouble(newObj[2]);
                        double sp = Double.parseDouble(newObj[3]);
                        boolean s = Boolean.parseBoolean(newObj[4]);
                        int q = Integer.parseInt(newObj[5]);
                        Inventory newInv = new Inventory(n, id, p, sp, s, q);
                        int index = parts.findInventorybyName(newInv.getPartName());
                        if (index == -1) {
                            parts.add(newInv);
                        } else {
                            parts.updateInventory(newInv, index);
                        }
                    }
                    System.out.println("The inventory has been added from the file you selected");
                    fileRead.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not Found. Try Again");
                } catch (InputMismatchException e) {
                    System.out.println("There was an error reading the file. Try Again.");
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
                    int index = parts.findInventorybyName(newInv.getPartName());
                    if (index == -1) {
                        parts.add(newInv);
                    } else {
                        parts.updateInventory(newInv, index);
                    }
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Sorry. There was a problem with your entry.");
                    System.out.println();
                    input.nextLine();
                }
            } else if ((user.equals("Sell") || (user.equals("sell") || (user.equals("SELL"))))) {
                try {
                    System.out.println("Enter the part number: ");
                    int number = input.nextInt();
                    int index = parts.findInventorybyNumber(number);

                    if (index == -1) {
                        System.out.println();
                        System.out.println("This item is not currently in stock.");
                        System.out.println();
                    } else {
                        parts.get(index).decrease(1);
                    }

                    if (index == -1) {
                        System.out.println();
                        System.out.println("This item is not currently in stock.");
                        System.out.println();
                    } else {
                        if (parts.get(index).isOnSale()) {
                            System.out.println("Name: " + parts.get(index).getPartName() + " " + "Price: " + parts.get(index).getSalesPrice() + " " + "Quantity: " + parts.get(index).getQuantity());
                        } else {
                            System.out.println("Name: " + parts.get(index).getPartName() + " " + "Price: " + parts.get(index).getPrice() + " " + "Quantity: " + parts.get(index).getQuantity());
                        }
                    }
                    System.out.println();
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Sorry. There was a problem with your entry.");
                    System.out.println();
                    input.nextLine();
                }
            } else if ((user.equals("Display") || user.equals("display") || user.equals("DISPLAY"))) {
                try {
                    System.out.println("Enter the part name: ");
                    String partName = input.next();
                    int index = parts.findInventorybyName(partName);
                    if (index == -1) {
                        System.out.println();
                        System.out.println("This item is not currently in stock.");
                        System.out.println();
                    } else {
                        if (parts.get(index).isOnSale()) {
                            System.out.println("Name: " + parts.get(index).getPartName() + " " + "Price: " + parts.get(index).getSalesPrice());
                        } else {
                            System.out.println("Name: " + parts.get(index).getPartName() + " " + "Price: " + parts.get(index).getPrice());
                        }
                        System.out.println();
                    }
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Sorry. There was a problem with your entry.");
                    System.out.println();
                    input.nextLine();
                }
            } else if ((user.equals("SortName")) || (user.equals("sortname")) || (user.equals("SORTNAME"))) {
                System.out.println("Please select from the following: ");
                System.out.println();
                System.out.println("Warehouse: Sort items by warehouse.");
                System.out.println("SalesVan: Sort items by SalesVan.");
                System.out.println("Total: Sort items by combined warehouses and sales vans.");
                System.out.println();
                System.out.println("Enter your choice: ");
                user = input.next();
                System.out.println();
                if (user.equals("Warehouse") || user.equals("warehouse") || user.equals("WAREHOUSE")) {
                    parts.sortByName();
                    int counter = 0;
                    while (counter <= parts.size() - 1) {
                        System.out.println(parts.get(counter));
                        ++counter;
                    }
                } else if (user.equals("salesvan") || user.equals("SalesVan") || user.equals("SALESVAN")) {

                    if (mainFleet.size() == 0) {
                        System.out.println();
                        System.out.println("Sorry. There are no sales vans available.");
                        System.out.println();
                    } else {
                        System.out.println("Please enter the name of the sales van: ");
                        String s = input.next();
                        SalesVan v = mainFleet.findSalesVane(s);
                        v.sortByName();
                        int counter = 0;
                        while (counter < v.size() - 1) {
                            System.out.println(v.get(counter));
                            ++counter;
                        }
                    }
                } else if (user.equals("total") || user.equals("Total") || user.equals("TOTAL")) {
                    Warehouse sortWH = new Warehouse("total");
                    int counter = 0;
                    while (counter <= parts.size() - 1) {
                        sortWH.add(parts.get(counter));
                        ++counter;
                    }
                    if (mainFleet.size() == 0) {
                        sortWH.sortByName();
                        counter = 0;
                        while (counter <= sortWH.size() - 1) {
                            System.out.println(sortWH.get(counter));
                            ++counter;
                        }
                    } else {
                        counter = 0;
                        while (counter <= mainFleet.size() - 1) {
                            SalesVan van = mainFleet.get(counter);
                            int counter2 = 0;
                            while (counter2 <= van.size() - 1) {
                                sortWH.add(van.get(counter));
                                ++counter2;
                            }
                            ++counter;
                        }
                        sortWH.sortbyNumber();
                        counter = 0;
                        while (counter <= sortWH.size() - 1) {
                            System.out.println(sortWH.get(counter));
                            ++counter;
                        }
                    }
                } else if ((user.equals("SortNumber")) || (user.equals("sortnumber")) || (user.equals("SORTNUMBER"))) {
                    System.out.println("Please select from the following: ");
                    System.out.println();
                    System.out.println("Warehouse: Sort items by warehouse.");
                    System.out.println("SalesVan: Sort items by SalesVan.");
                    System.out.println("Total: Sort items by combined warehouses and sales vans.");
                    System.out.println();
                    System.out.println("Enter your choice: ");
                    user = input.next();
                    System.out.println();

                    if (user.equals("Warehouse") || user.equals("warehouse") || user.equals("WAREHOUSE")) {
                        parts.sortbyNumber();
                        int counter = 0;
                        while (counter <= parts.size() - 1) {
                            System.out.println(parts.get(counter));
                            ++counter;
                        }
                    } else if (user.equals("salesvan") || user.equals("SalesVan") || user.equals("SALESVAN")) {

                        if (mainFleet.size() == 0) {
                            System.out.println();
                            System.out.println("Sorry. There are no sales vans available.");
                            System.out.println();
                        } else {
                            System.out.println("Please enter the name of the sales van: ");
                            String s = input.next();
                            SalesVan v = mainFleet.findSalesVane(s);
                            v.sortbyNumber();
                            int counter = 0;
                            while (counter < v.size() - 1) {
                                System.out.println(parts.get(counter));
                                ++counter;
                            }
                        }
                    } else if (user.equals("total") || user.equals("Total") || user.equals("TOTAL")) {
                        Warehouse sortWH = new Warehouse("total");
                        int counter = 0;
                        while (counter <= parts.size() - 1) {
                            sortWH.add(parts.get(counter));
                            ++counter;
                        }
                        if (mainFleet.size() == 0) {
                            sortWH.sortbyNumber();
                            counter = 0;
                            while (counter <= sortWH.size() - 1) {
                                System.out.println(sortWH.get(counter));
                                ++counter;
                            }
                        } else {
                            counter = 0;
                            while (counter <= mainFleet.size() - 1) {
                                SalesVan van = mainFleet.get(counter);
                                int counter2 = 0;
                                while (counter2 <= van.size() - 1) {
                                    sortWH.add(van.get(counter));
                                    ++counter2;
                                }
                                ++counter;
                            }
                            sortWH.sortbyNumber();
                            counter = 0;
                            while (counter <= sortWH.size() - 1) {
                                System.out.println(parts.get(counter));
                                ++counter;
                            }
                        }

                    }

                } else if ((user.equals("Move")) || (user.equals("MOVE")) || (user.equals("move"))) {
                    System.out.println("Enter the name of the Sales Van Delivery File: ");
                    String fileName = input.next();
                    try {
                        File readFile = new File(fileName);
                        Scanner fileRead = new Scanner(readFile);

                        System.out.println("Enter WarehouseToSalesVan or SalesVanToSalesVan");

                        user = input.next();
                        if (user.equals("WarehouseToSalesVan")) {
                            String newEntry = fileRead.nextLine();
                            String[] newObj = newEntry.split(",");
                            String mainWarehouse = newObj[0];
                            String salesVanName = newObj[1];
                            while (fileRead.hasNext()) {
                                newEntry = fileRead.nextLine();
                                newObj = newEntry.split(",");
                                String name = newObj[0];
                                int quantity = Integer.parseInt(newObj[1]);
                                mainAss.move(parts.getWarehouse(), mainFleet.findSalesVane(salesVanName), name, quantity);
                            }
                        } else if (user.equals("SalesVanToSalesVan")) {
                            String newEntry = fileRead.nextLine();
                            String[] newObj = newEntry.split(",");
                            String salesVanName1 = newObj[0];
                            String salesVanName2 = newObj[1];
                            while (fileRead.hasNext()) {
                                newEntry = fileRead.nextLine();
                                newObj = newEntry.split(",");
                                String name = newObj[0];
                                int quantity = Integer.parseInt(newObj[1]);
                                mainAss.move(mainFleet.findSalesVane(salesVanName1), mainFleet.findSalesVane(salesVanName2), name, quantity);
                                System.out.print(mainFleet.findSalesVane("SalesVanA"));
                            }
                        } else {
                            System.out.println("Your Inventory File Could Not Be Processed.");
                            System.out.println();
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println();
                        System.out.println("File Not Found. Try Again");
                        System.out.println();
                    }
                } else if ((user.equals("Add")) || user.equals("add") || user.equals("ADD")) {
                    System.out.println("Please enter the name of the sales van: ");
                    String vanName = input.next();
                    SalesVan van = new SalesVan(vanName);
                    mainFleet.add(van);
                    System.out.println("Van added to the fleet.");
                } else {
                    if (!(user.equals("quit") || user.equals("Quit") || user.equals("QUIT"))) {
                        System.out.println();
                        System.out.println("Sorry. That's not a valid selection.");
                        System.out.println();
                    }
                }
                input.nextLine();
            }
            System.out.println();


            FileWriter fileWriter = new FileWriter("warehouseDB.txt", false);
            PrintWriter writer = new PrintWriter(fileWriter);

            int counter = 0;
            while (counter <= parts.size() - 2) {
                writer.println(parts.get(counter));
                ++counter;
            }
            while (counter <= parts.size() - 1) {
                writer.print(parts.get(counter));
                ++counter;
            }
            writer.close();
            input.close();
            System.out.println("Thank you. Goodbye.");
        }
    }
}

