package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

import Blackop778.ChemCalc.Elements.Element;
import Blackop778.ChemCalc.Elements.ElementDatabase;
import Blackop778.ChemCalc.Elements.NoElementException;

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
		else if(command.equalsIgnoreCase("mole"))
		{
			return getMole(input);
		}
		else if(command.equalsIgnoreCase("help"))
		{
			return new InputReturn("help", "Commands:"
					+ "\nmass  -  [atomic symbol, name, or number] returns the mass of the element. Will eventually allow polyatomics.");
		}
		else
			return new InputReturn("Error", "Not a valid command. Enter 'help' for valid commands");
	}

	public static InputReturn getMass(Scanner input)
	{
		String next = input.next();
		Element element;

		// Get the element from the database
		try
		{
			element = ElementDatabase.atomicNumberGet(Integer.valueOf(next));
		}
		catch(NumberFormatException e)
		{
			try
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
			catch(NoElementException e1)
			{
				IOManager.output(e1.getLocalizedMessage());
			}
		}

		double mass = element.getAtomicMass();
		String Mass = String.valueOf(mass);
		InputReturn inputreturn = new InputReturn("mass", Mass);
		return inputreturn;
	}

	public static InputReturn getMole(Scanner input)
	{
		String[] inputArray = Libs.scannerToArray(input);
		if(inputArray.length == 2)
		{
			String element = inputArray[0];
			double inputMass = Double.valueOf(inputArray[1]);
		}
		else
		{
			return new InputReturn("blah", "no polyatomics");
			// TODO Add polyatomic support
		}
	}
}
