package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

import Blackop778.ChemCalc.Elements.ElementDatabase;

public class InputProcessing
{
	static InputReturn ProcessInput(String Input)
	{
		Scanner input = new Scanner(Input);
		if(input.next().equals("mass"))
			return new InputReturn("mass",
					String.valueOf(ElementDatabase.atomicSymbolMap.get(input.next()).getAtomicMass()));
		else
			return new InputReturn("Error", "Not a valid argument");
	}
}
