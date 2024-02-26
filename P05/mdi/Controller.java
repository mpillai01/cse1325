package mdi;
import store.Store;
import java.util.Scanner;
import store.Customer;
import store.Tool;
import store.Plant;
import store.Exposure;

public class Controller{
	private Store store;
	private View view;
	private Menu mainMenu;
	private String output;
	private boolean isRunning;
	private Scanner in =new Scanner(System.in);
	
	public Controller(String storeName){
		this.store= store;
		this.view=view;
		this.mainMenu=mainMenu;
		this.output=output;
		this.isRunning=isRunning;
		this.in=in;
	}
	
	 // Method mdi() runs the menu system
    public void mdi() {
        while(isRunning) {
            try {
                // Select an item from the menu
                Character c = selectFromMenu();
                if(c == null) continue;
                boolean valid = false;
                
                // Execute the handler for the selected item
                if(c == '1') {valid = true; placeOrder();  }
                if(c == '2') {valid = true; newCustomer();  }
                if(c == '3') {valid = true; newTool();      }
                if(c == '4') {valid = true; newPlant();  }
                if(c == '5') {valid = true; switchView(); }        
                               
                if(c == '0') break;
                if(!valid) print("#### Invalid command: " + c);
                
            } catch (Exception e) {
                print("#### Unexpected Error: " + e.getMessage());
            } 
        }
    }
    private static String clearScreen = "\n".repeat(255);
    private Character selectFromMenu() {
        System.out.println(clearScreen + '\n');
        System.out.println("0) Exit);");
        System.out.println("1) Place Order");
        System.out.println("2) Welcome new Customer");
        System.out.println("3) Define new Tool");
        System.out.println("4) Define new Plant");
        System.out.println("5) Switch View");
        System.out.println();        
        return getChar("Selection? ");
    }
	
	 // Show the prompt and return a char (or \0)
    private Character getChar(String prompt) {
        Character c = null;
        while(true) {
            try  {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) c = s.charAt(0);
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return c;
    }
	
	private void exit(){
		isRunning = false;
	}
	
	private void placeOrder(){
		store.getCustomerList();
		System.out.print("Enter customer placing order: \n");
    int customer = in.nextInt();
	int order_num = store.newOrder(customer);
	store.getProductList();
	System.out.print("Enter product : \n");
    int prod_num = in.nextInt();	
	System.out.print("Enter product quantiry: \n");
    int quantity = in.nextInt();	
	store.addToOrder(order_num, prod_num, quantity);
		
	}
	
	private void newCustomer(){
	System.out.print("Enter name of customer: \n");
    String name = in.nextLine();
	
	System.out.print("Enter email of customer: \n");
	String email = in.nextLine();
	Customer customer = new Customer(name,email);
	store.addCustomer(customer);
	System.out.println("Customer successfully added to the store\n");
	store.getCustomerList();
	}
	
	private void newTool(){
	System.out.print("Enter name of Tool: \n");
    String name = in.nextLine();
	
	System.out.print("Enter price of Tool: \n");
	int price = in.nextInt();
	Tool product = new Tool(name,price);
	store.addProduct(product);
	System.out.println("Product successfully added to the store\n");
	store.getProductList();
	}
	
	private void newPlant(){
	System.out.print("Enter name of plant: \n");
    String name = in.nextLine();
	
	System.out.print("Enter exposure: \n");
	String exposure = in.nextLine();
	
	System.out.print("Enter price of plant: \n");
	int price = in.nextInt();
	Plant plant = new Plant(name,price, Exposure.SUN);
	store.addProduct(plant);
	System.out.println("Plant successfully added to the store\n");
	store.getProductList();
	}
	
	private  void switchView(){
	}
	
	private String getView(){
		return "";
	}	
	
	
	 private void print(String s) {
        output += s + '\n';
    }
    	
	
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
	
}
	
	