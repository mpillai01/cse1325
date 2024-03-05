package mdi;
// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by Mahadev Pillai
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

import store.Store;
import store.Customer;
import store.Order;
import store.Item;
import store.Product;
import store.Tool;
import store.Plant;
import store.Exposure;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


import java.util.Scanner;

public class Controller {
	private String filename = "Untitled";
	private Customer customerCreated= null;
	private Tool productCreated= null;
	private Plant plantCreated= null;
	Customer customer = new Customer(
            "Mahadev", "mxp5138@mavs.uta.edu");
	Product p2 = new Tool("Gardening Shovel", 1200);
	Product p3 = new Plant("Valiant Apricot Vinca",Exposure.SUN,1105);
	Item i2 = new Item(p2, 5);
    public Controller(String storeName) {
        this.store = new Store(storeName);
        this.view = View.CUSTOMERS;
        this.isRunning = true;
        this.output = "";
        
        this.in = new Scanner(System.in);
        
        mainMenu = new Menu();
        mainMenu.addMenuItem(new MenuItem("Exit",                 () -> exit()));
        mainMenu.addMenuItem(new MenuItem("Place Order",          () -> placeOrder()));
        mainMenu.addMenuItem(new MenuItem("Welcome new Customer", () -> newCustomer()));
        mainMenu.addMenuItem(new MenuItem("Define new Tool",      () -> newTool()));
        mainMenu.addMenuItem(new MenuItem("Define new Plant",     () -> newPlant()));
        mainMenu.addMenuItem(new MenuItem("Switch View",          () -> switchView()));

    }
    public void mdi() {
        // System.err.println("====> Starting mdi");
        Integer selection = null;
        while(isRunning) {
            // System.err.println("====> Start of main loop");
            try {
                selection = selectFromMenu();
                output = "";
                if(selection == null) continue;
                if(selection == -1) testData();
                else mainMenu.run(selection);
            } catch(Exception e) {
                // e.printStackTrace();
                // getString("Press Enter to continue");
                print("#### Error: " + e.getMessage());
            }
        }
    }
	 public void test() {
       // Create and print a simple object
     
        System.out.println(customer.toString());
		       
        // Save the object to a simple file
        System.out.println("\nWriting Customer data to " + filename);
        save();
        
        // Save as a new filename
        //System.out.println("\nWriting Simple data to a new filename");
        //saveAs();
        
        // Open to a new Simple object
        System.out.println("\nOpening a Simple file");
       open();
        System.out.println(customerCreated.toString());
        System.out.println(productCreated.toString());
		//System.out.println(plantCreated.toString());
        
	}
    private String getView() {
        String result = "INVALID VIEW";
        if(view == View.CUSTOMERS) result = store.getCustomerList();
        if(view == View.PRODUCTS)  result = store.getProductList();
        if(view == View.ORDERS)    result = store.getOrderList();
        return result;
    }

    // Show the main menu and return the char selected
    private static final String clearScreen = "\n".repeat(255);
    private Integer selectFromMenu() {
        System.out.println(clearScreen 
                         + store.getName() + " Main Menu\n\n" 
                         + mainMenu + '\n' 
                         + getView() + '\n'
                         + output + '\n');
        output = "";
        return getInt("Selection? ");
    }

    // /////////////////////////////////////////////////////////////////////////
    //                          O B S E R V E R S
    private void exit() {
        isRunning = false;
    }
    
    private void placeOrder() {
        System.out.println("\nPlacing an Order\n----------------\n");
        int customer = getInt("\n" + store.getCustomerList() + "\nWhich Customer? ");
        if(customer < 0) return;
        int order = store.newOrder(customer);
        while(true) {
            int product = getInt("\n" + store.getProductList() 
                               + "\nWhich Product (-1 to complete order)? ");
            if(product < 0) break;
            int quantity = getInt("How many (-1 to select a different product)? ");
            if(quantity < 0) continue;
            store.addToOrder(order, product, quantity);
        }
        print("Created order " + order);
        view = View.ORDERS;
    }
    
    private void newCustomer() {
        System.out.println("\nDefining a new Customer\n-----------------------\n");
        String name = getString("New Customer's name:  ");
        String email = getString("New Customer's email: ");
        Customer customer = new Customer(name, email);
        store.addCustomer(customer);
        print("Created new Customer: " + customer);
        view = View.CUSTOMERS; 
    }
    
    private void newTool() {
        System.out.println("\nDefining a new Tool\n-------------------\n");
        String name = getString("New Tool's name:  ");
        double price = getDouble("New Tool's price: ");
        Tool tool = new Tool(name, (int) (price * 100));
        store.addProduct(tool);
        print("Created new Tool: " + tool);
        view = View.PRODUCTS; 
    }
    
    private void newPlant() {
        System.out.println("\nDefining a new Plant\n-------------------\n");
        String name = getString("New Plant's name:  ");
        
        Exposure exposure = null;
        try {
            System.out.println();
            for(Exposure ex : Exposure.values())
                System.out.println(ex.ordinal() + "] " + ex);
            int selection = getInt("\nNew Plant's exposure? ");
            exposure = Exposure.values()[selection];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Invalid Exposure");
        }

        double price = getDouble("New Plant's price: ");
        Plant plant = new Plant(name, exposure, (int) (price * 100));
        store.addProduct(plant);
        print("Created new Plant: " + plant);
        view = View.PRODUCTS; 
    }
    
    private void switchView() {
        System.out.println("\nSwitching View\n--------------\n");
        for(View view : View.values())
            System.out.println(view.ordinal() + "] " + view);
        int selection = getInt("\nSelection? ");
        view = View.values()[selection];
        print("Switched view to " + view);
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          U S E R   O U T P U T
    // Instead of System.out.println, which would put output ABOVE the menu,
    //   collect output in a String field and print it BETWEEN the menu
    //   and the prompt. This looks MUCH nicer!
    private void print(String s) {
        output += s + '\n';
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          B A S I C   U S E R   I N P U T
    // Show the prompt and return a string
    private String getString(String prompt) {
        String s = null;
        while(true) {
            try  {
                System.out.print(prompt);
                s = in.nextLine().trim();
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return s;
    }
    
    // Show the prompt and return an Integer (or null)
    private Integer getInt(String prompt) {
        Integer i = null;
        while(true) {
            try  {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) i = Integer.parseInt(s);
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return i;
    }
    
    // Show the prompt and return a double (or null)
    private Double getDouble(String prompt) {
        Double d = null;
        while(true) {
            try  {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) d = Double.parseDouble(s);
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return d;
    }
	  private void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
           store.addCustomer(customer);
		   store.addProduct(p2);
		 store.addProduct(p3);
		   store.save(bw);
		   // customer.save(bw);
            System.out.println("Wrote  to " + filename);
        } catch (Exception e) {
            System.err.println("Failed to save: " + e);
        }
    }
	  private void saveAs() {
        System.out.print("Enter a Simple filename to save: ");
        String s = in.nextLine();
        if(s.isEmpty()) return;
        filename = s;
        save();
    }

	private void open() {
        System.out.print("Enter a filename to open (Enter for '" 
                       + filename + "'): ");
        String s = in.nextLine();
        if(!s.isEmpty()) filename = s;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            customerCreated= new Customer(br);
            System.out.println("Opened customer from " + filename);
            productCreated= new Tool(br);
            System.out.println("Opened tool from " + filename);
			//plantCreated= new Plant(br);
            //System.out.println("Opened plant from " + filename);
        } catch (Exception e) {
            System.err.println("Failed to read: " + e);
            customerCreated = null;
        }
    }
    

    // /////////////////////////////////////////////////////////////////////////
    //                          F I E L D S
    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    
    private Scanner in;
    
    public void testData() {
            Customer c1 = new Customer("Prof Rice", "george.rice@uta.edu");
            Customer c2 = new Customer("President Joe Biden", "president@whitehouse.gov");
            Customer c3 = new Customer("The Late Queen Elizabeth II", "queen@royal.gov.uk");
            Customer c4 = new Customer("Mark Zuckerberg", "mark.zuckerberg@facebook.com");
            store.addCustomer(c1);
            store.addCustomer(c2);
            store.addCustomer(c3);
            store.addCustomer(c4);

            Product p1 = new Plant("Cactus Cereus Peruvianus", Exposure.SUN, 4990);
            Product p2 = new Plant("'White Princess' Philodendron", Exposure.PARTSUN, 5500);
            Product p3 = new Tool("Bypass Pruners", 2299);
            Product p4 = new Tool("Large Gardener's Cart", 34900);
            store.addProduct(p1);
            store.addProduct(p2);
            store.addProduct(p3);
            store.addProduct(p4);
            
            int order = store.newOrder(0);
            store.addToOrder(order, 0, 4);
            store.addToOrder(order, 1, 3);
            store.addToOrder(order, 2, 2);
            store.addToOrder(order, 3, 1);
/*
            Item i1 = new Item(p1, 4);
            Item i2 = new Item(p2, 3);
            Item i3 = new Item(p3, 2);
            Item i4 = new Item(p4, 1);

            Order o1 = new Order(c1);
            o1.addItem(i1);
            o1.addItem(i2);
            o1.addItem(i3);
            o1.addItem(i4);
            store.addOrder(o1);
*/
    }
}