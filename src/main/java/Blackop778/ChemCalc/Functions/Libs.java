package Blackop778.ChemCalc.Functions;

import java.util.Scanner;

public class Libs
{
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
}
