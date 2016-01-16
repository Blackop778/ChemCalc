package Blackop778.ChemCalc.Elements;

public class Element
{
	private int atomicNumber;
	private String name;
	private String symbol;
	private double atomicMass;

	public Element(int atomicNumber, String name, String symbol, double atomicMass)
	{
		this.atomicNumber = atomicNumber;
		this.name = name;
		this.symbol = symbol;
		this.atomicMass = atomicMass;
	}

	public int getAtomicNumber()
	{
		return atomicNumber;
	}

	public String getName()
	{
		return name;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public double getAtomicMass()
	{
		return atomicMass;
	}
}
