package store;
import store.Item;
import java.util.ArrayList;

/**
* @author Mahadev Pillai
* @version 0.2
* @since 0.2
* @license.agreement Gnu General Public License 3.0
*/

public class Order{
/**
* @param customer Customer type.
* @since 0.2
*/
public Order(Customer customer){
orderNumber = nextOrderNumber + 1;
this.customer = customer;
this.items=items;
}
/**
* @param item Item type.
* @since 0.2
*/
public void addItem(Item item){
	items.add(item);
}
/**
* @return int integer type
* @since 0.2
*/
private int getPrice(){
	int sum =0;
	 for(Item i : items) {
              sum = sum + i.getPrice(); 
                
            }
	 return sum;
 }
 /**
* @return int integer type
* @since 0.2
*/
 public int getOrderNumber(){
	 return orderNumber;
 }
 
 /**
* @return String string type
* @since 0.2
*/
@Override
 public String toString() {
	 Double d2=Double.valueOf(getPrice());
	 String strRet = "Order #" + getOrderNumber()+ " for " +  customer+ "\n"+ items
	 +"\n" + "Order Total" +"$" + " " + String.format("%5.2f",d2/100);
	 return strRet;
	 
 }
private static int nextOrderNumber = 0;
private int orderNumber;	
private static ArrayList<Item> items = new ArrayList<>();
	Customer customer;

}