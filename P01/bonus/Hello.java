import java.util.Scanner;

public class Hello{
	public static void main(String[] args){
		String name;
		Scanner in = new Scanner (System.in);
		System.out.print("What is your name? ");
		name = in.nextLine();
		System.out.println("Hello, " + name+"!");
	}
}
