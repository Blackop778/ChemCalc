package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

public class IOManager
{
	private static final boolean ECLIPSECONSOLEIO = true;
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

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

	static Scanner getInput()
	{
		if(ECLIPSECONSOLEIO)
		{
			return new Scanner(input.nextLine());
		}
		else
		{
			// TODO Add stand alone IO
			return new Scanner("blah");
		}
	}

	public static Scanner getInput(String output)
	{
		output(output);
		return getInput();
	}
}
