package Blackop778.ChemCalc;

import java.util.Scanner;

import Blackop778.ChemCalc.Elements.NoElementException;
import Blackop778.ChemCalc.Functions.IOManager;
import Blackop778.ChemCalc.Functions.InputProcessing;
import Blackop778.ChemCalc.Functions.InputReturn;

public class ChemCalc
{

	public static void main(String[] args)
	{
		doIt();
	}

	public static void doIt()
	{
		Scanner input = IOManager.getInput("Please enter a command: ");
		InputReturn output;
		try
		{
			output = InputProcessing.processInput(input);
		}
		catch(NoElementException e)
		{
			output = new InputReturn("NoElementException", e.getLocalizedMessage());
		}
		IOManager.outputln(output);
		doItAgain();
	}

	public static void doItAgain()
	{
		Scanner input = IOManager.getInput("Run again?(Y/N) ");
		if(input.next().equalsIgnoreCase("Y"))
		{
			doIt();
		}
	}
}
