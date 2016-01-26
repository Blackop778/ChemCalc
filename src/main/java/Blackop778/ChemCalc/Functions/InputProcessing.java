package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

import Blackop778.ChemCalc.Elements.Element;
import Blackop778.ChemCalc.Elements.ElementDatabase;

public class InputProcessing
{
	/**
	 * Processes what is input and returns it as an InputReturn
	 * 
	 * @param inputScanner
	 *            The Scanner that contains what the user input
	 * @return An InputReturn with the processed output
	 */
	public static InputReturn processInput(Scanner inputScanner)
	{
		Scanner input = inputScanner;
		if(input.next().equalsIgnoreCase("mass"))
		{
			String next = input.next();
			Element element;
			try
			{
				element = ElementDatabase.atomicNumberGet(Integer.valueOf(next));
			}
			catch(NumberFormatException e)
			{
				if(next.length() < 4 && !next.equalsIgnoreCase("Tin"))
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
		else if(input.next().equalsIgnoreCase("help"))
		{
			return new InputReturn("blah", "blah");
		}
		else
			return new InputReturn("Error", "Not a valid argument. Enter 'help' for valid commands");
	}
}
