package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

import Blackop778.ChemCalc.Elements.ElementDatabase;

public class InputProcessing
{
	public static InputReturn processInput(Scanner inputScanner)
	{
		Scanner input = inputScanner;
		if(input.next().equals("mass"))
			return new InputReturn("mass",
					String.valueOf(ElementDatabase.atomicSymbolGet(input.next()).getAtomicMass()));
		else
			return new InputReturn("Error", "Not a valid argument");
	}
}
