public class Customer {
 
 public Customer(String name, String email) {
 String s = email.substring(email.lastIndexOf("@") + 1);
 if(email.contains("@") && s.contains(".")) {
 this.name = name; 
 this.email = email; 
 } else {
	 throw new IllegalArgumentException("Invalid email address "+email);
 }
}
@Override
 public String toString() {
 return name+"(" + email + ")";
 } 
 private String name; 
 private String email; 

}
