package store;
/**
* @author Mahadev Pillai
* @version 0.2
* @since 0.2
* @license.agreement Gnu General Public License 3.0
*/
import java.text.DecimalFormat;
public abstract class Product {
/**
* @param name                String type.
* @param price               int type.
* @since 0.2
*/
 public Product(String name, int price) {
 if(price<0) {
	throw new IllegalArgumentException("Invalid price of ["+name+"]: ["+price+"]");
 }
 stockNumber = nextStockNumber++;
 this.name = name;
 this.price = price;
}
@Override
/**
* @return String            String type.
* @since 0.2
*/
 public String toString() {
 
 int width = 30;
Double d1=Double.valueOf(price);
 return (String.format("%-" + width + "s", name)+ "$" + String.format("%5.2f",d1/100));
 } 
/**
* @return int            int type.
* @since 0.2
*/
 public int getStockNumber(){
	 return stockNumber;
 }
/**
* @return int            int type.
* @since 0.2
*/
 public int getPrice(){
	 return price;
 }
 
 private static int nextStockNumber = 0;
 private int stockNumber;
 private String name; 
 private int price;
}