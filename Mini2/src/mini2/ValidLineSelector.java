package mini2;

import api.Selector;

/**
 * Selector that returns false for a strings that are
 * empty, that are all whitespace, or whose first non-whitespace
 * character is the '#' character.
 */
public class ValidLineSelector implements Selector
{
  public boolean select(String line) {
	  line = line.trim();
	  if(line.isEmpty() || line.charAt(0) == '#') {
		  return false;
	  }
	  return true;
  }
}
