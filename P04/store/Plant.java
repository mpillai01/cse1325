package store;
public class Plant extends Product{
	Exposure exposure;
	public Plant(String species, int price, Exposure exposure){		
		super("Plant: " + species,price);
		this.exposure=exposure;
}
public Exposure getExposure(){
	return exposure;
}
}
