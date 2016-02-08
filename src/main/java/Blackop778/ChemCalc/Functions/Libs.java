package blackop778.chemcalc.functions;

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
	static String[] scannerToArray(Scanner scanner)
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
}
