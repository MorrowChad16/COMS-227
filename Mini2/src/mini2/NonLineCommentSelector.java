package mini2;

import api.Selector;

/**
 * Selector whose <code>select</code> method returns false for strings whose first non-whitespace
 * text is "//", and true for all other strings.
 */
public class NonLineCommentSelector implements Selector
{
  public boolean select(String line) {
	  line = line.trim()+1;
	  return line.charAt(0) !='/' || line.charAt(1) !='/';
  }
}