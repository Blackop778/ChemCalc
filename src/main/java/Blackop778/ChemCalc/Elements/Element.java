package Blackop778.ChemCalc.Elements;

public class Element
{
	private final int atomicNumber;
	private final String name;
	private final String atomicSymbol;
	private final double atomicMass;
	private final byte charge;

	/**
	 * Creates a new Element and stores it's data
	 * 
	 * @param atomicNumber
	 *            The Element's atomic number
	 * @param name
	 *            The Element's name
	 * @param atomicSymbol
	 *            The Element's atomic symbol
	 * @param atomicMass
	 *            The Element's atomic mass
	 * @param charge
	 *            The Element's charge, where 127 represents it has no charge
	 */
	protected Element(int atomicNumber, String name, String atomicSymbol, double atomicMass, byte charge)
	{
		this.atomicNumber = atomicNumber;
		this.name = name;
		this.atomicSymbol = atomicSymbol;
		this.atomicMass = atomicMass;
		this.charge = charge;
	}

	/**
	 * 
	 * @return The Element's atomic number
	 */
	public int getAtomicNumber()
	{
		return atomicNumber;
	}

	/**
	 * 
	 * @return The Element's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 
	 * @return The Element's atomic symbol
	 */
	public String getAtomicSymbol()
	{
		return atomicSymbol;
	}

	/**
	 * 
	 * @return The Element's atomic mass
	 */
	public double getAtomicMass()
	{
		return atomicMass;
	}

	/**
	 * 
	 * @return The Element's charge, or null if it is unknown
	 */
	public Byte getCharge()
	{
		if(charge == 127)
			return new Byte(null);
		else
			return charge;
	}
}
