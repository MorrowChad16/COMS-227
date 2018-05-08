package postage1;

import java.util.Scanner;

public class PostageUtil
{
  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   */
	public static void main(String[] args) {
		  System.out.print("Enter the weight of your package: ");
		  Scanner scan = new Scanner(System.in);
		  double weight = scan.nextDouble();
		  System.out.println(weight);
		  System.out.println(PostageUtil.computePostage(weight));
	  }
	
  public static double computePostage(double weight)
  {
	  double cost;
	  if (weight <= 1) {
		       cost = .47;
	  }
		    else
		        if (weight <= 3.5) {
		            cost = .47 + Math.ceil(weight - 1) * .21;
		        }
		        else
		        {
		            cost = .94 + Math.ceil(weight - 1) * .21;
		        }
    return cost;
  }
  
}