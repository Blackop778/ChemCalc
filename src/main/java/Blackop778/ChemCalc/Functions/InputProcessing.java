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
		String command = input.next();
		if(command.equalsIgnoreCase("mass"))
		{
			return getMass(input);
		}
		else if(command.equalsIgnoreCase("help"))
		{
			return new InputReturn("help", "Commands:"
					+ "\nmass  -  [atomic symbol, name, or number] returns the mass of the element. Will eventually allow polyatomics.");
		}
		else
			return new InputReturn("Error", "Not a valid command. Enter 'help' for valid commands");
	}

	public static InputReturn getMass(Scanner inputScanner)
	{
		String next = inputScanner.next();
		Element element;

		// Get the element from the database
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

		// Make sure the element was found then return the element's mass
		if(element != null)
		{
			double mass = element.getAtomicMass();
			String Mass = String.valueOf(mass);
			InputReturn inputreturn = new InputReturn("mass", Mass);
			return inputreturn;
		}
		else
		{
			return new InputReturn("Error", "Error, could not find an element with your atomic symbol/name/number.");
		}
	}
}
