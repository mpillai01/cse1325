package store;
/**
* @author Mahadev Pillai
* @version 0.2
* @since 0.2
* @license.agreement Gnu General Public License 3.0
*/
public class Plant extends Product{
	Exposure exposure;
/**
* @param species             String type.
* @param price               int type.
* @param exposure            Exposure type.
* @since 0.2
*/
	public Plant(String species, int price, Exposure exposure){		
		super("Plant: " + species,price);
		this.exposure=exposure;
}
/**
* @return Exposure            Exposure type.
* @since 0.2
*/
public Exposure getExposure(){
	return exposure;
}
}
