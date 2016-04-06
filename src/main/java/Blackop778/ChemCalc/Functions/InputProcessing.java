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
	 * @throws ProcessedError
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
		else if(command.equalsIgnoreCase("help"))
			return getHelp(input);
		else if(command.equalsIgnoreCase("credits"))
			return new InputReturn("credits",
					"This app was developed by Blackop778, also known as Nathan F. Contact me at nefalt@att.net.");
		else
			return new InputReturn("Error", "Not a valid command. Enter 'help' for valid commands.");
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

	public static InputReturn getMole(Scanner input) throws NoElementException, SyntaxError
	{
		String[] inputArray = Libs.scannerToArray(input);
		if(inputArray.length > 1)
		{
			double inputMass;
			try
			{
				inputMass = Double.valueOf(inputArray[0]);
			}
			catch(NumberFormatException e)
			{
				Scanner errorS = new Scanner(e.getLocalizedMessage());
				errorS.useDelimiter("\"");
				errorS.next();
				String error = errorS.next();
				errorS.close();
				throw new SyntaxError("Error: expected a double, recieved '" + error + "'.");
			}
			String tempString = Libs.arrayToString(inputArray, 1, inputArray.length);
			Scanner tempScanner = new Scanner(tempString);
			InputReturn temp = getMass(tempScanner);
			double elementMass = Double.valueOf(temp.getOutput());
			double moles = inputMass / elementMass;
			return new InputReturn("mole", String.valueOf(moles), inputArray, temp.getInputType());
		}
		else
			return new InputReturn("error", "Error: Additional arguments expected.");
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

	public static InputReturn getHelp(Scanner input)
	{
		if(!input.hasNext())
			return new InputReturn("help", "Commands:"
					+ "\nEvery argument must be seperated by spaces. For example to get the mass of 'C2H5Cl' you would type:"
					+ "\n'mass C 2 H 5 Cl' or 'P(CO2)3' --> 'mass P C 3 O 6'"
					+ "\nmass  -  [atomic symbol, name, or number]"
					+ "\nmole  -  [atomic mass] [atomic symbol, name, or number]"
					+ "\nname  -  [atomic mass, number, or symbol]" + "\nsymbol  -  [atomic mass, number, or name]"
					+ "\ncharges  -  [atomic mass, number, name, or symbol]" + "\nhelp  -  [command name]"
					+ "\ncredits");
		else
		{
			String next = input.next();
			if(next.equalsIgnoreCase("mass"))
				return new InputReturn("help", "Returns the atomic mass of the element or polyatomic specified.");
			else if(next.equalsIgnoreCase("mole"))
				return new InputReturn("help", "Returns how many moles worth of an element or polyatomic are present.");
			else if(next.equalsIgnoreCase("name"))
				return new InputReturn("help", "Returns the name of the element specified.");
			else if(next.equalsIgnoreCase("symbol"))
				return new InputReturn("help", "Returns the atomic symbol of the element specified.");
			else if(next.equalsIgnoreCase("charges"))
				return new InputReturn("help", "Returns the possible charges of the element specified.");
			else if(next.equalsIgnoreCase("help"))
				return new InputReturn("help",
						"Displays detailed information for the specified command, or a list of commands if none specified.");
			else if(next.equalsIgnoreCase("credits"))
				return new InputReturn("help",
						"Displays information crediting the creator of this program, Blackop778.");
			else
				return new InputReturn("help",
						"'" + next + "' is not a valid command. Enter 'help' for a list of valid commands.");
		}
	}
}
