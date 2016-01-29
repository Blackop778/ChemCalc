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
	 * @throws NoElementException
	 */
	public static InputReturn processInput(Scanner inputScanner) throws NoElementException
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

	public static InputReturn getMass(Scanner input) throws NoElementException
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

	public static InputReturn getMole(Scanner input) throws NoElementException
	{
		String[] inputArray = Libs.scannerToArray(input);
		if(inputArray.length == 1)
		{
			double elementMass = ElementDatabase.massUnknownInputGet(inputArray[0]);
			double inputMass = Double.valueOf(inputArray[1]);
			double moles = inputMass / elementMass;
			return new InputReturn("moles", String.valueOf(moles));
		}
		else
		{
			return new InputReturn("blah", String.valueOf(inputArray.length));
			// TODO Add polyatomic support
		}
	}
}
