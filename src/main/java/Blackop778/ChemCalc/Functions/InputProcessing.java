package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

import Blackop778.ChemCalc.Elements.ElementDatabase;
import Blackop778.ChemCalc.Elements.NoElementException;

public abstract class InputProcessing
{
	/**
	 * Processes what is input and returns it as an InputReturn
	 * 
	 * @param inputScanner
	 *            The Scanner that contains what the user input
	 * @return An InputReturn with the processed output
	 * @throws NoElementException
	 * @throws SyntaxError
	 */
	public static InputReturn processInput(Scanner inputScanner) throws NoElementException, SyntaxError
	{
		Scanner input = inputScanner;
		String command = input.next();
		if(command.equalsIgnoreCase("mass"))
			return getMass(input);
		else if(command.equalsIgnoreCase("mole"))
			return getMole(input);
		else if(command.equalsIgnoreCase("name"))
			return getName(input);
		else if(command.equalsIgnoreCase("symbol"))
			return getSymbol(input);
		else if(command.equalsIgnoreCase("charges"))
			return getCharges(input);
		else if(command.equalsIgnoreCase("credits"))
			return new InputReturn("credits",
					"This app was developed by Blackop778, also known as Nathan F. Contact me at nefalt@att.net.");
		else if(command.equalsIgnoreCase("help"))
			return new InputReturn("help",
					"Commands:"
							+ "\nNOTE: arg stands for argument, or words typed after the initial command which modify the command."
							+ "\nmass  -  [atomic symbol, name, or number] returns the mass of arg 1. Will eventually allow polyatomics."
							+ "\nmole  -  [atomic mass] [atomic symbol, name, or number] returns how many moles of arg 1 you have with a mass of arg 2."
							+ "\nname  -  [atomic mass, number, or symbol] returns the name of the element that matches the input."
							+ "\nsymbol  -  [atomic mass, number, or name] returns the symbol of the element that matches the input."
							+ "\ncharges  -  [atomic mass, number, name, or symbol] returns the charges of the element that matches the input."
							+ "\ncredits  -  returns information about the creator.");
		else
			return new InputReturn("Error", "Not a valid command. Enter 'help' for valid commands");
	}

	public static InputReturn getMass(Scanner input) throws NoElementException, SyntaxError
	{
		String[] inputStorage = Libs.scannerToArray(input);
		InputReturn inputReturn;

		if(inputStorage.length > 1)
		{
			boolean coeffSet = false;
			double mass = 0;
			int coeff = 1;
			for(int i = 0; i < inputStorage.length; i++)
			{
				if(Libs.isInt(inputStorage[i]))
				{
					if(!coeffSet)
					{
						coeff = Integer.valueOf(inputStorage[i]);
						coeffSet = true;
					}
					else
						throw new SyntaxError("Error: Consecutive integers detected in a polynomial.");
				}
				else
				{
					double temp = Double.valueOf(ElementDatabase.massUnknownInputGet(inputStorage[i]).getOutput());

					if(i + 1 != inputStorage.length)
					{
						if(Libs.isInt(inputStorage[i + 1]))
						{
							i++;
							temp = temp * Double.valueOf(inputStorage[i]);
						}
					}

					mass += temp;
				}
			}

			mass = mass * coeff;

			inputReturn = new InputReturn("mass", String.valueOf(mass), inputStorage, "polyatomic");
		}
		else
		{
			InputReturn temp = ElementDatabase.massUnknownInputGet(inputStorage[0]);
			inputReturn = new InputReturn("mass", temp.getOutput(), inputStorage, temp.getInputType());
		}

		return inputReturn;
	}

	public static InputReturn getMole(Scanner input) throws NoElementException
	{
		String[] inputArray = Libs.scannerToArray(input);
		if(inputArray.length == 2)
		{
			double inputMass = Double.valueOf(inputArray[0]);
			InputReturn temp = ElementDatabase.massUnknownInputGet(inputArray[1]);
			double elementMass = Double.valueOf(temp.getOutput());
			double moles = inputMass / elementMass;
			return new InputReturn("mole", String.valueOf(moles), inputArray, temp.getInputType());
		}
		else if(inputArray.length == 1)
			return new InputReturn("error", "Additional arguments expected.");
		else
			return new InputReturn("blah", "Polyatomics not currently supported.");
		// TODO Add polyatomic support
	}

	public static InputReturn getName(Scanner input) throws NoElementException
	{
		String[] inputArray = Libs.scannerToArray(input);
		if(inputArray.length == 1)
		{
			InputReturn temp = ElementDatabase.nameUnknownInputGet(inputArray[0]);

			return new InputReturn(temp.getReturnType(), temp.getOutput(), inputArray, temp.getInputType());
		}
		else if(inputArray.length > 1)
			return new InputReturn("blah", "Polyatomics not currently supported.");
		else
			return new InputReturn("error", "Additional arguments expected.");
	}

	public static InputReturn getSymbol(Scanner input) throws NoElementException
	{
		String[] inputArray = Libs.scannerToArray(input);

		if(inputArray.length == 1)
		{
			InputReturn temp = ElementDatabase.symbolUnknownInputGet(inputArray[0]);

			return new InputReturn(temp.getReturnType(), temp.getOutput(), inputArray, temp.getInputType());
		}
		else
			return new InputReturn("error", "1 and only 1 argument expected.");
	}

	public static InputReturn getCharges(Scanner input) throws NoElementException
	{
		String[] inputArray = Libs.scannerToArray(input);

		if(inputArray.length == 1)
		{
			InputReturn temp = ElementDatabase.chargeUnknownInputGet(inputArray[0]);

			return new InputReturn(temp.getReturnType(), temp.getOutput(), inputArray, temp.getInputType());
		}
		else
			return new InputReturn("error", "1 and only 1 argument expected.");

	}
}
