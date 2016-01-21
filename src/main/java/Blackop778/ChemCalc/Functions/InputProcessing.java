package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

import Blackop778.ChemCalc.Elements.Element;
import Blackop778.ChemCalc.Elements.ElementDatabase;

public class InputProcessing
{
	public static InputReturn processInput(Scanner inputScanner)
	{
		Scanner input = inputScanner;
		if (input.next().equals("mass"))
		{
			String next = input.next();
			Element element;
			try
			{
				element = ElementDatabase.atomicNumberGet(Integer.valueOf(next));
			}
			catch (NumberFormatException e)
			{
				if (next.length() < 4 && !next.equalsIgnoreCase("Tin"))
				{
					element = ElementDatabase.atomicSymbolGet(next);
				}
				else
				{
					element = ElementDatabase.atomicNameGet(next);
				}

			}
			double mass = element.getAtomicMass();
			String Mass = String.valueOf(mass);
			InputReturn inputreturn = new InputReturn("mass", Mass);
			return inputreturn;
		}
		else
			return new InputReturn("Error", "Not a valid argument");
	}
}
