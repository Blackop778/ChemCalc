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
	 */
	public static InputReturn processInput(Scanner inputScanner) throws NoElementException
	{
		Scanner input = inputScanner;
		String command = input.next();
		if(command.equalsIgnoreCase("mass"))
			return getMass(input);
		else if(command.equalsIgnoreCase("mole"))
			return getMole(input);
		else if(command.equalsIgnoreCase("help"))
			return new InputReturn("help", "Commands:"
					+ "\nNOTE: arg stands for argument, or words typed after the initial command which modify the command."
					+ "\nmass  -  [atomic symbol, name, or number] returns the mass of arg 1. Will eventually allow polyatomics."
					+ "\nmole  -  [atomic symbol, name, or number] [atomic mass] returns how many moles of arg 1 you have with a mass of arg 2.");
		else
			return new InputReturn("Error", "Not a valid command. Enter 'help' for valid commands");
	}

	public static InputReturn getMass(Scanner input) throws NoElementException
	{
		String[] inputStorage = Libs.scannerToArray(input);

		InputReturn temp = ElementDatabase.massUnknownInputGet(inputStorage[0]);

		InputReturn inputreturn = new InputReturn("mass", temp.getOutput(), inputStorage, temp.getInputType());
		return inputreturn;
	}

	public static InputReturn getMole(Scanner input) throws NoElementException
	{
		String[] inputArray = Libs.scannerToArray(input);
		if(inputArray.length == 2)
		{
			InputReturn temp = ElementDatabase.massUnknownInputGet(inputArray[0]);
			double elementMass = Double.valueOf(temp.getOutput());
			double inputMass = Double.valueOf(inputArray[1]);
			double moles = inputMass / elementMass;
			return new InputReturn("mole", String.valueOf(moles), inputArray, temp.getInputType());
		}
		else if(inputArray.length == 1)
			return new InputReturn("error", "Additional arguments expected.");
		else
			return new InputReturn("blah", "Polyatomics not currently supported.");
		// TODO Add polyatomic support
	}
}
