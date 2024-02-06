public class TestProduct {
    public static void main(String[] args) {
		int errors =0;
        try {            
            Product p1 = new Product("Cactus Cereus Peruvianus", 4990);
			System.out.println("First Stock number is " +p1.getStockNumber());
            if (p1.getStockNumber() != 0){ 
            System.err.println("FAIL: 0 expected but got " + p1.getStockNumber());
			errors++;
			}
			Product p2 = new Product("'White Princess' Philodendron", 5500);
			System.out.println("Second Stock number is " +p2.getStockNumber());
			 if (p2.getStockNumber() != 1){ 
            System.err.println("FAIL: 1 expected but got " + p2.getStockNumber());
			errors++;
			}
			System.out.println("getPrice for first product is " +p1.getPrice());
			if (p1.getPrice() != 4990){ 
            System.err.println("FAIL: 4990 expected but got " + p1.getPrice());
			errors++;
			}
            Product p3 = new Product("6 inch English Lavender", 2909);
            Product p4 = new Product("'Hayi' Rhaphidophora", 3299);

            System.out.println("Products are:\n  "
                             + p1 + "\n  " + p2 + "\n  "+ p3 + "\n  " + p4);
		 try {
			 System.out.println("Product with negative price -1 \n");
           Product p5 = new Product("Cactus Cereus Peruvianus", -1); 
        } catch(Exception e) {			
            System.err.println(e.getMessage());
            System.exit(-1);
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