package hw1;

public class Cab {
	//
	private double baseRate;
	
	private double perMileRate;
	private double miles; 
	private double meter;
	private double totalMiles;
	private double moneyCollected;
	private boolean passenger;
	private double currentRate;
	
	
	//sets up the cab's base rate and cost per mile rate while driving with a passenger
	public Cab(double givenBaseRate, double givenPerMileRate) {
		moneyCollected = 0;
		baseRate = givenBaseRate;
		perMileRate = givenPerMileRate;
		meter = 0;
		moneyCollected = 0;
		totalMiles = 0;
		miles = 0;
		passenger = false;
		currentRate = 0;
		
	}
	
	//distance driven with or without a passenger
	public void drive(double givenMiles) {
		
		miles = givenMiles;

		totalMiles = totalMiles + miles;
		
		meter = meter + givenMiles * currentRate;
		
	}
	
	//total miles driven in an instance (with passenger or without a passenger)
	public double getTotalMiles() {
		return totalMiles;
	}
	
	//meter is the miles driven with a passenger in the car times the per mile rate plus the base rate. 
	public double getMeter() {
		
		return meter;
	}
	
	//getTotalCash reads how much money was given to driver out of the total charged
	public double getTotalCash() {
		
		return moneyCollected;
	}
	
	
	// current rate goes back and forth between $0 per mile to the per mile rate defined at the beginning
	// this is determined by whether a passenger is in the car or not. 
	public double getCurrentRate() {
	
		return currentRate;
	}
	
	//tells the program that a passenger is in the car
	public void pickUp() {
		currentRate = perMileRate;
		meter = baseRate;
		passenger = true;
			
	}
	
	//tells the code that there isn't a passenger in the car
	//
	public void dropOff() {
		currentRate = 0;
		passenger = false;
		moneyCollected += meter;
		meter = 0;
		miles = 0;

		
	}
	
	public boolean hasPassenger() {
		return passenger;
	}
	
	public double getAverageIncomePerMile() {
		return moneyCollected/totalMiles;
	}
	
}
