package postage1;

import java.util.Scanner;

public class ComputePostage {
	public static void main(String[] args) {
	Scanner i = new Scanner (System.in);
	System.out.print("Enter a weight: ");
	double compute = i.nextDouble();
	System.out.println(compute);
	i.close();
	}
}
