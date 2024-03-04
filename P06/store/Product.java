package store;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;

public abstract class Product {
    public Product(String name, int price) {
        if(price < 0) 
            throw new IllegalArgumentException("Invalid price of " + name + ": " + price/100 + "." + price%100);
        this.name = name;
        this.stockNumber = nextStockNumber++;
        this.price = price;
    }
    public int getStockNumber() {
        return stockNumber;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return String.format("%-40s $%5d.%02d", name, price/100, price%100);
    }
	public Product(BufferedReader br) throws IOException {
		br.readLine();
		br.readLine();  
        this.name  = br.readLine();
        this.price = Integer.parseInt    (br.readLine());
		this.stockNumber=Integer.parseInt    (br.readLine());
		this.nextStockNumber=Integer.parseInt    (br.readLine());
    }
    
	public void save(BufferedWriter bw) throws IOException {
        bw.write("" + name    + '\n');
        bw.write("" + price  + '\n');
		bw.write("" + stockNumber  + '\n');
		bw.write("" + nextStockNumber  + '\n');
		
    }
	
	
    public String name;
    public int stockNumber;
    public int price;
    public static int nextStockNumber = 0;
}