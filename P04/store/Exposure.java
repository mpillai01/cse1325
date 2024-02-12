package store;
/**
* @author Mahadev Pillai
* @version 0.2
* @since 0.2
* @license.agreement Gnu General Public License 3.0
*/

	public enum Exposure{
	SHADE,SUN,PARTSUN;
/**
* @return String            String type
* @since 0.2
*/
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
