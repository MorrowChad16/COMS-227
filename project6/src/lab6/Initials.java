package lab6;

import java.util.Scanner;

public class Initials {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name: ");
		System.out.println("Your initials are: " + initial(scan.nextLine()));
		System.out.println("Enter a statement: ");
		System.out.println("Index of first vowel is: " + numVowels(scan.nextLine()));
		scan.close();
	}
	
	public static String initial(String text) {
		  
		String initial = "";
		Scanner input = new Scanner(text);

		while(input.hasNext()) {
				initial += input.next().substring(0,1);
			}
		input.close();
		return initial;
	}
	
	public static int numVowels(String text) {
		for(int i = 1; i< text.length()+1; i++) {
			if("aeiouAEIOU".indexOf(text.substring(i-1, i)) >= 0) {
				return i -1;
			}
		}
		return -1;
	}
}
