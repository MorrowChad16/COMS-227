package lab2;

public class StringTest {
	public static void main(String[] args){
		//Declares original message
		String message = "Hola Senor";
		System.out.println(message);
		
		//capitalizes the whole message
		message = message.toUpperCase();
		System.out.println(message);
		
		//Prints first word ONLY
		String FirstWordChars = "";
		FirstWordChars = message.substring(0, 4);
		System.out.println(FirstWordChars);
		
		//replaces O with * 
		String ReplaceLetters = message.replace('O', '*');
		System.out.println(ReplaceLetters);
		
		//Prints char in 0 position
		char theChar = message.charAt(0);
		System.out.println(theChar);
		
		//prints char in 1 position
		theChar = message.charAt(1);
		System.out.println(theChar);
	}
}
