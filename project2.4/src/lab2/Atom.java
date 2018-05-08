package lab2;

public class Atom {
	 /**
	   * proton count 
	   */
	private int Protons; 
	 /**
	   * electron count
	   */
	private int Electrons;
	 /**
	   * neutron count
	   */
	private int Neutrons; 
	
	/**
	   * @param givenProtons, givenNeutrons, givenElectrons
	   *   defines elements
	   */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) {
		 Protons = givenProtons;
		 Neutrons = givenNeutrons;
		 Electrons = givenElectrons;
		}
	 /**
	   * Returns the atomic mass
	   * @return
	   *   mass of this atom
	   */
	public int getAtomicMass() {
		return Protons + Neutrons; 
	}
	 /**
	   * returns the atomic charge
	   * @return
	   *   charge of atom
	   */
	public int getAtomicCharge() {
		return Protons - Electrons; 
	
	}
	 /**
	   * decreases protons and neutrons
	   */
	public void decay() {
		Protons = Protons - 2;
		Neutrons = Neutrons - 2;
	}
}
