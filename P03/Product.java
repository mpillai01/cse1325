import java.text.DecimalFormat;
public class Product {
 
 public Product(String name, int price) {
 if(price<0) {
	throw new IllegalArgumentException("Invalid price of ["+name+"]: ["+price+"]");
 }
 stockNumber = nextStockNumber++;
 this.name = name;
 this.price = price;
}
@Override
 public String toString() {
 
 int width = 30;
Double d1=Double.valueOf(price);
 return (String.format("%-" + width + "s", name)+ "$" + String.format("%5.2f",d1/100));
 } 
 private int getStockNumber(){
	 return stockNumber;
 }
 private int getPrice(){
	 return price;
 }
 
 private static int nextStockNumber = 0;
 private int stockNumber;
 private String name; 
 private int price;

public static void main(String[] args) {
 Product p1 = new Product("Cactus Cereus Peruvianus", 4990);
 Product p2 = new Product("'White Princess' Philodendron", 5500);
 Product p3 = new Product("6 inch English Lavender", 2909);
 Product p4 = new Product("'Hayi' Rhaphidophora", 3299);
 System.out.println("" + p1);
 System.out.println("" + p2);
 } 

}