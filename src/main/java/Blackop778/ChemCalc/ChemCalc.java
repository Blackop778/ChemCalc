package blackop778.chemcalc;

import java.util.Scanner;

import blackop778.chemcalc.elements.NoElementException;
import blackop778.chemcalc.functions.IOManager;
import blackop778.chemcalc.functions.InputProcessing;
import blackop778.chemcalc.functions.InputReturn;

public class ChemCalc
{

	public static void main(String[] args)
	{
		doIt();
	}

	/**
	 * Does the thing. Runs the program.
	 */
	public static void doIt()
	{
		Scanner input = IOManager.getInput("Please enter a command(ex. 'help'): ");

		InputReturn output;
		try
		{
			output = InputProcessing.processInput(input);
		}
		catch(NoElementException e)
		{
			output = new InputReturn("NoElementException", e.getLocalizedMessage());
		}

		IOManager.finalOutput(output);

		doItAgain();
	}

	/**
	 * Asks the user if they want to do the thing again.
	 */
	public static void doItAgain()
	{
		Scanner input = IOManager.getInput("Run again?(Y/N) ");

		if(input.next().equalsIgnoreCase("Y"))
		{
			doIt();
		}
	}
}
