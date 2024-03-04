package store;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;

public class Plant extends Product {
    public Plant(String species, Exposure exposure, int price) {
        super("Plant: " + species, price);
        this.exposure = exposure;
    }
    public Exposure getExposure() {
        return exposure;
    }
    private Exposure exposure;
	public Plant(BufferedReader br) throws IOException {
       super(br);
	this.exposure = Exposure.valueOf(br.readLine());
		
		
    }
	public void save(BufferedWriter bw) throws IOException {
		//super.save();
		bw.write("" + name    + '\n');
        bw.write("" + price  + '\n');
		bw.write("" + stockNumber  + '\n');
		bw.write("" + nextStockNumber  + '\n');
	    bw.write("" + exposure    + '\n');
       
        
    }
}