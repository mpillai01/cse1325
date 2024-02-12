package store;
import java.text.DecimalFormat;
public abstract class Product {
 
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
 public int getStockNumber(){
	 return stockNumber;
 }
 public int getPrice(){
	 return price;
 }
 
 private static int nextStockNumber = 0;
 private int stockNumber;
 private String name; 
 private int price;
}