package mini2;

import api.Combiner;

/**
 * Combiner that appends the first letter of a string onto
 * the accumulator.  If the string is empty, returns the 
 * accumulator.
 */
public class FirstLetterCombiner implements Combiner<String>
{
  public String combine(String result, String val) {
	  if(val.length()==0) {
	  return result;
	  }
	  return result + val.charAt(0);
  }
}
