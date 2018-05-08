package lab5;


public class Basketball {
	
private double diameter;
private boolean isDribble;

  public Basketball(double givenDiameter)
  {
	  diameter = givenDiameter;
	  isDribble = false;
  }

  public boolean isDribbleable()
  {
    return isDribble;
  }

  public double getDiameter()
  {
    return diameter;
  }

  public double getCircumference()
  {
    return Math.PI * diameter;
  }

  public void inflate()
  {
	  isDribble = true;
  }
}