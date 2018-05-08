package postage3;

public class Postage3Util
{
  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   */
  public static double computePostage(double weight)
  {
	  double cost;
	  cost = .47;
	  if (weight > 1) {
		  cost = .47 + Math.ceil(weight - 1) * .21;   
	  }
	  if(weight > 3.5) {
		cost = cost + 0.47;
	  }
    return cost;
  }

}
