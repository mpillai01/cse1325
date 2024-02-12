package store;
import store.Item;
import java.util.ArrayList;
public class Order{

public Order(Customer customer){
orderNumber = nextOrderNumber + 1;
this.customer = customer;
this.items=items;
}
public void addItem(Item item){
	items.add(item);
}
private int getPrice(){
	int sum =0;
	 for(Item i : items) {
              sum = sum + i.getPrice(); 
                
            }
	 return sum;
 }
 private int getOrderNumber(){
	 return orderNumber;
 }
 
 
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
