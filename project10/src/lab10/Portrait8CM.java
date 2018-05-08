package lab10;
// Joshua Loftus ComSci 227 Section A Lab Section 14
import java.awt.Graphics;

public class Portrait8CM extends Portrait
	{
	
	public Portrait8CM()
		{
		super(0.2);
		setBodyHeight(0.25);
		setArmSpan(0.3);
		setArmRaise(.2);
		setNeckHeight(.075);
		}
		
		
		
	@ Override
	public void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		int midX = getWidth() / 2;
		int eyeRadius = 2;
		g.fillOval(headRadius + 20, headRadius - eyeRadius * 2, 2 * eyeRadius, 2 * eyeRadius);
		g.fillOval(headRadius + 35, headRadius - eyeRadius * 2, 2 * eyeRadius, 2 * eyeRadius);
		int smileRadius = (int) (0.4 * headRadius);
		g.drawArc(midX - smileRadius, (int) (0.8 * headRadius) + 3, smileRadius * 2, smileRadius * 2, 0, -180);
		}
	}