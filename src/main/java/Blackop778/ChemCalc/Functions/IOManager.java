package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

public abstract class IOManager
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
	 * Gets a string that will be output in a new line to the user
	 * 
	 * @param output
	 *            The string that will be output
	 */
	static void outputln(String output)
	{
		if(ECLIPSECONSOLEIO)
		{
			System.out.println(output);
		}
		else
		{
			// TODO Add stand alone IO
		}
	}

	/**
	 * Allows for the final output to be more sophisticated and include text.
	 * 
	 * @param input
	 *            Contains the information to be output
	 */
	public static void finalOutput(InputReturn input)
	{
		String output;

		if(input.getReturnType().equals("mass"))
		{
			if(input.getInputType().equals("symbol") || input.getInputType().equals("name"))
			{
				output = "The mass of " + input.getInputs()[0] + " is " + input.getOutput() + "g.";
			}
			else if(input.getInputType().equals("number"))
			{
				output = "The mass of the element with an atomic number of " + input.getInputs()[0] + " is "
						+ input.getOutput() + "g.";
			}
			else
			{
				output = input.getOutput();
			}
		}
		else if(input.getReturnType().equals("mole"))
		{
			if(input.getInputType().equals("symbol") || input.getInputType().equals("name"))
			{
				output = input.getInputs()[1] + "g of " + input.getInputs()[0] + " is equalivalent to "
						+ input.getOutput() + " moles.";
			}
			else if(input.getInputType().equals("number"))
			{
				output = input.getInputs()[1] + "g of the element with an atomic number of " + input.getInputs()[0]
						+ " is equalivalent to " + input.getOutput() + " moles.";
			}
			else
			{
				output = input.getOutput();
			}
		}
		else
		{
			output = input.getOutput();
		}

		outputln(output);
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
	 * Outputs the output of the InputReturn passed to it on a new line
	 * 
	 * @param output
	 *            The InputReturn that's output will be output
	 */
	public static void outputln(InputReturn output)
	{
		if(ECLIPSECONSOLEIO)
		{
			System.out.println(output.getOutput());
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
	public static Scanner getInput()
	{
		if(ECLIPSECONSOLEIO)
		{
			Scanner test = new Scanner(input.nextLine());
			return test;
		}
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
		if(ECLIPSECONSOLEIO)
		{
			output(output);
			return getInput();
		}
		else
			// TODO Add stand alone IO
			return new Scanner("blah");
	}
}
