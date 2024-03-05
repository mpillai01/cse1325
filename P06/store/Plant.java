package store;
// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by Mahadev Pillai
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
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