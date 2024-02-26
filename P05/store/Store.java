package store;
import java.util.ArrayList;
public class Store
{
	private String name;
	private ArrayList<Customer> customers;
	private ArrayList<Product> products;
	private ArrayList<Order> orders;

	public Store(String name)
	{
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addCustomer(Customer customer){
		customers.add(customer);
	}
	
	public String getCustomerList(){		
		StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<customers.size() ; ++i)
            sb.append(" " + i + "] " + customers.get(i) + "\n");
       return sb.toString();
		
	}
	
	 
	
	public void addProduct(Product product){
		products.add(product);
	}
	
	public String getProductList(){
		StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<products.size() ; ++i)
            sb.append(" " + i + "] " + products.get(i) + "\n");
       return sb.toString();
	}
	
	public int newOrder(int customer){
		Order order = new Order(customers.get(customer));
		orders.add(order);		
		return order.getOrderNumber();
	}
	
	public void addToOrder(int order, int product, int quantity){
		Item item = new Item(products.get(product), quantity);
		orders.get(order).addItem(item);
		
	}
	
	public String getOrderList(){
		StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<orders.size() ; ++i)
            sb.append(" " + i + "] " + orders.get(i) + "\n");
       return sb.toString();
	}
}

	
