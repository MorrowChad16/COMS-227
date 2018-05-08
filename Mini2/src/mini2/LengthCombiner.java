package mini2;

import api.Combiner;

/**
 * Adds the length of the given string to the accumulator
 * and returns the result.
 */
public class LengthCombiner implements Combiner<Integer>
{
  public Integer combine(Integer accumulator, String val) {
	  return accumulator + val.length();
  }
}
