package store;
	enum Exposure{
	SUN,PARTSUN;
@Override
public String toString(){
	 switch (this) {
		 case SUN:
			return "full sun";
		 case PARTSUN: 
			return "part sun/part shade";
		default:
            return null;
}
}
	}
