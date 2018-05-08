package mini2;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import api.Converter;
import plotter.Polyline;

/**
 * Converts a string into a <code>Polyline</code> object.  The given 
 * string must conform to the format specified for one valid line of the file 
 * as described in Lab 8, checkpoint 2.  See
 * <pre>
 * http://web.cs.iastate.edu/~cs227/labs/lab8/page12.html
 * </pre>
 */
public class PolylineConverter implements Converter<Polyline>
{
	public Polyline convert(String line) {
		Polyline noodle;
		Scanner temp = new Scanner(line);
		if(Character.isDigit(line.charAt(0)))
		{
			int width = temp.nextInt();
			String color = temp.next();
			noodle = new Polyline(color,width);
		}
		else
		{
			String color = temp.next();
			noodle = new Polyline(color);
		}
		while(temp.hasNext())
		{
			noodle.addPoint(new Point(temp.nextInt(),temp.nextInt()));
		}
		temp.close();
		return noodle;
	}
}
