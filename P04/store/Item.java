package store;
/**
* @author Mahadev Pillai
* @version 0.2
* @since 0.2
* @license.agreement Gnu General Public License 3.0
*/
public class Item {
 /**
* @param product             Product type.
* @param quantity            int type.
* @since 0.2
*/
 public Item(Product product, int quantity) { 
 this.product = product;
 this.quantity = quantity;
}
/**
* @return String       String type.
* @since 0.2
*/
@Override
 public String toString() { 
 Double d2=Double.valueOf(getPrice());
 String strItem = quantity +" "+ product + " "+ "$" + " " + String.format("%5.2f",d2/100);
 return strItem;
 }  
 /**
* @return int       integer type.
* @since 0.2
*/
 public int getPrice(){
	 return product.getPrice()*quantity;
 }
 
 private Product product; 
 private int quantity;
}