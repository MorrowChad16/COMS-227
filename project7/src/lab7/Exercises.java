package lab7;

public class Exercises {

public static void main(String[] args) {
	int numbers[] = {-42, 42, 5, -7};
	System.out.println();
}

public static int[] getPositiveNumbers(int[] numbers) {
	int position = 0;
	int[] positive = new int[15];
	for(int i = 0; i < numbers.length; i++) {
		
		if(numbers[i]>0) {
			positive[position] = numbers[i];
			position++;
		}
	}
	return positive;
}

public static int[] randomExperiment(int max, int iters) {
	
}
}