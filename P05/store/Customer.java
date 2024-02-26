package store;
/**
* @author Mahadev Pillai
* @version 0.2
* @since 0.2
* @license.agreement Gnu General Public License 3.0
*/
public class Customer {
 /**
* @param name             String type.
* @param email            String type.
* @since 0.2
*/
 public Customer(String name, String email) {
 String s = email.substring(email.lastIndexOf("@") + 1);
 if(email.contains("@") && s.contains(".")) {
 this.name = name; 
 this.email = email; 
 } else {
	 throw new IllegalArgumentException("Invalid email address "+email);
 }
}
/**
* @return String           String type
* @since 0.2
*/
@Override
 public String toString() {
 return name+"(" + email + ")";
 } 
 private String name; 
 private String email; 

}