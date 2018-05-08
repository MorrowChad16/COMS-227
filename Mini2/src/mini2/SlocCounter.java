package mini2;

import api.Combiner;

/**
 * Combiner whose <code>combine</code> method, given an Integer n and a string, 
 * returns n if the string is a blank line or a line containing
 * a single curly brace; otherwise returns n + 1.  (A curly brace on a line whose
 * only other text is an end-of-line comment is treated as just a curly brace.)
 * Using a SlocCounter in the reduce method has the general effect of counting 
 * the number of "source lines of code" that are actual program statements,
 * assuming that line comments and javadoc comments have already been
 * filtered out.
 */
public class SlocCounter implements Combiner<Integer>
{
	public Integer combine(Integer n, String line) {
		line = line.trim();
		if(line.isEmpty()) {
			return n;
		}
		if((line.charAt(0) == '{' || line.charAt(0) == '}') && !line.contains("else")) {
			return n;
		}
		if(line.contains("//") || line.contains("/*")) {
			return n;
		}
		return n+1;
	}
}