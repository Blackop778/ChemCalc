package Blackop778.ChemCalc.Elements;

public class PolyatomicIon extends Element
{
	private final String expandedSymbol;

	protected PolyatomicIon(int atomicNumber, String name, String atomicSymbol, String expandedSymbol,
			double atomicMass, byte[] charges)
	{
		super(atomicNumber, name, atomicSymbol, atomicMass, charges);
		this.expandedSymbol = expandedSymbol;
	}

	public String getExpandedSymbol()
	{
		return expandedSymbol;
	}
}
