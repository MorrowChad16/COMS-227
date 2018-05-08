package lab3;

public class TestMode1 {
	public static void main(String[] args)
	  {
	    RabbitModel model = new RabbitModel();
	    
	    // Check that the initial population is 2
	    System.out.println(model.getPopulation());
	    System.out.println("Expected 500");
	    
	    // A year goes by...
	    model.simulateYear();
	    System.out.println(model.getPopulation());
	    System.out.println("Expected 250");
	    model.simulateYear();
	    System.out.println(model.getPopulation());
	    System.out.println("Expected 125");
	    
	    // Start over
	    model.reset();
	    System.out.println("Expected 2");
	  }
}
