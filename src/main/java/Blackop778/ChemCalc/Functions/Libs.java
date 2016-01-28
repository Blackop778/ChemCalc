package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

public class Libs
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
	static String[] scannerToArray(Scanner scanner)
	{
		String[] output = new String[scannerLength(scanner) - 1];

		int i = 0;
		while(scanner.hasNext())
		{
			output[i] = scanner.next();
			i++;
		}

		return output;
	}
}
