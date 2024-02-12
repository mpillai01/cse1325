package store;
	public enum Exposure{
	SHADE,SUN,PARTSUN;
@Override
public String toString(){
	 switch (this) {
		 case SHADE:
			return "part shade";
		 case SUN:
			return "full sun";
		 case PARTSUN: 
			return "part sun";
		default:
            return null;
}
}
	}
