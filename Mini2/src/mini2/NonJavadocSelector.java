package mini2;

import api.Selector;

/**
 * Selector that returns false if the current string is
 * within a javadoc comment, true otherwise.  Using a NonJavadocSelector
 * in the filter method of a StringList has the effect of removing all
 * javadoc comments.  Note that we are assuming that javadoc comments
 * always start and end on different lines, and that no executable
 * code ever appears on the same line as a javadoc comment.
 */
public class NonJavadocSelector implements Selector
{
	private boolean isComment = false;
	public boolean select(String line) {
		if(line.contains("/**"))
		{
			isComment = true;
			return false;
		}
		else if(line.contains("*/"))
		{
			isComment = false;
			return false;
		}
		else if(isComment)
			return false;
		return true;
	}
}
