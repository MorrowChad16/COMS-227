package lab3;
import java.util.Random;
public class RabbitModel {
	private int population; 
	Random rabbit = new Random(10);
	
	public RabbitModel() {
		population = 500;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void simulateYear() {
		population = population + rabbit.nextInt(11);
	}
	
	public void reset() {
		population = 500;
	}
}
