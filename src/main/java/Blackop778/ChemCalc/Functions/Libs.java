package Blackop778.ChemCalc.Functions;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Libs
{
	/**
	 * Gets the number of times input() can be ran before running out of
	 * arguments
	 * 
	 * @param scanner
	 *            The scanner to get the length of
	 * @return The number of arguments left in the scanner
	 */
	static int scannerLength(Scanner scanner)
	{
		int count = 0;
		while(scanner.hasNext())
		{
			scanner.next();
			count++;
		}
		return count;
	}

	/**
	 * Converts a Scanner's remaining inputs to a String[]
	 * 
	 * @param scanner
	 *            The Scanner whose inputs become a String[]
	 * @return A String[] containing the remaining inputs of scanner
	 */
	public static String[] scannerToArray(Scanner scanner)
	{
		ArrayList<String> intermediateStorage = new ArrayList<String>();

		while(scanner.hasNext())
		{
			intermediateStorage.add(scanner.next());
		}

		intermediateStorage.trimToSize();
		String[] toReturn = new String[intermediateStorage.toArray().length];
		intermediateStorage.toArray(toReturn);
		return toReturn;
	}

	public static boolean containsLetters(String input)
	{
		boolean toReturn = false;
		String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "and", "z"};

		for(String letter : letters)
		{
			if(input.contains(letter) || input.contains(letter.toUpperCase()))
			{
				toReturn = true;
			}
		}

		return toReturn;
	}

	static String arrayToString(String[] source)
	{
		String output = "";
		for(String temp : source)
		{
			output = output + " " + temp;
		}

		return output.substring(0, source.length);
	}

	public static Boolean isInt(String input)
	{
		try
		{
			@SuppressWarnings("unused")
			int i = Integer.valueOf(input);
		}
		catch(Exception e)
		{
			return false;
		}

		return true;
	}
}
