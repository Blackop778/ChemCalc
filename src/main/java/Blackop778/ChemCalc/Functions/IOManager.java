package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

public class IOManager
{
	private static final boolean ECLIPSECONSOLEIO = true;
	private static final Scanner input = new Scanner(System.in);

	/**
	 * Gets a string that will be output to the user
	 * 
	 * @param output
	 *            The string that will be output
	 */
	static void output(String output)
	{
		if(ECLIPSECONSOLEIO)
		{
			System.out.print(output);
		}
		else
		{
			// TODO Add stand alone IO
		}
	}

	/**
	 * Outputs the output of the InputReturn passed to it
	 * 
	 * @param output
	 *            The InputReturn that's output will be output
	 */
	public static void output(InputReturn output)
	{
		if(ECLIPSECONSOLEIO)
		{
			System.out.print(output.getOutput());
		}
		else
		{
			// TODO Add stand alone IO
		}
	}

	/**
	 * Gets the user's input and returns it
	 * 
	 * @return A Scanner that contains what the user input
	 */
	static Scanner getInput()
	{
		if(ECLIPSECONSOLEIO)
			return new Scanner(input.nextLine());
		else
			// TODO Add stand alone IO
			return new Scanner("blah");
	}

	/**
	 * Outputs a string then returns what the user inputs as a Scanner
	 * 
	 * @param output
	 *            A string that will be output by output(String)
	 * @return A Scanner that contains what the user input
	 */
	public static Scanner getInput(String output)
	{
		output(output);
		return getInput();
	}
}
