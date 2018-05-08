package lab10;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Cyclops look a lot like you and me, but they only have one eye.
 */
public class Portrait0CRJ extends Portrait
{

	public Portrait0CRJ() 
	{
		super(0.5);

	    	setBodyHeight(0.2);
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
		//done with life portrait
		super.paintComponent(g);
		int midX = super.getWidth()/2;
		int eyeRadius = (int)(0.05 * SIZE);
		g.setColor(Color.PINK);
		
		//eyes
		g.fillOval(midX - 16 - eyeRadius, headRadius - eyeRadius + 10, 2 * eyeRadius - 2, 2 * eyeRadius - 2);
		g.fillOval(midX + 16 - eyeRadius, headRadius - eyeRadius + 10, 2 * eyeRadius - 2, 2 * eyeRadius - 2);

		//upside down smile
	    	int smileRadius = (int)(0.1 * headRadius);
	    	g.drawArc(midX - smileRadius, (int)(0.5 * headRadius), smileRadius * 2, smileRadius * 2, 0, 160);
	}
}