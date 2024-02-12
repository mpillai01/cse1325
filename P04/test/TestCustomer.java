package test;
import store.Customer;

public class TestCustomer {
    public static void main(String[] args) {
		int exception2 =0;
		int exception1 =0;
		int errors =0;
        try {            
            Customer c1 = new Customer("Prof Rice", "george.rice@uta.edu");
            Customer c2 = new Customer("President Joe Biden", "president@whitehouse.gov");
            Customer c3 = new Customer("The Late Queen Elizabeth II", "queen@royal.gov.uk");
            Customer c4 = new Customer("Mark Zuckerberg", "mark.zuckerberg@facebook.com");
      
            System.out.println(" customers are\n  "
                             + c1 + "\n  " + c2 + "\n  "+ c3 + "\n  " + c4);
			try {
		  System.out.println("Customer with invalid email address \n");
           Customer c5 = new Customer("Mark Zuckerberg", "mark.zuckerberg");
        } catch(Exception e) {			
            System.err.println(e.getMessage());
            exception1 ++;
        }				
		try {
		  System.out.println("Customer with invalid email address \n");
           Customer c6 = new Customer("Mark Zuckerberg", "mark.zuckerberg@facebookcom");
        } catch(Exception e) {			
            System.err.println(e.getMessage());
            exception2 ++;
        }
        if (exception1==0) {
			errors++;
			
		}
		if (exception2==0) {
			errors++;
			
		}
		} catch(Exception e) {
            System.err.println("Failed to create and print objects: \n" + e);
        }
		if (errors!=0) {
			System.out.println("There are " + errors + "failures during testing");
			
		}	
			
		System.exit(0);
    }
}