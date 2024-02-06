public class Item {
 
 public Item(Product product, int quantity) { 
 this.product = product;
 this.quantity = quantity;
}
@Override
 public String toString() { 
 Double d2=Double.valueOf(getPrice());
 String strItem = quantity +" "+ product + " "+ "$" + " " + String.format("%5.2f",d2/100);
 return strItem;
 }  
 private int getPrice(){
	 return product.getPrice()*quantity;
 }
 
 private Product product; 
 private int quantity;
}