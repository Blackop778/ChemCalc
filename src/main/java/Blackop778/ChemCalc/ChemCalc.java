package Blackop778.ChemCalc;

import Blackop778.ChemCalc.Functions.IOManager;
import Blackop778.ChemCalc.Functions.InputProcessing;

public class ChemCalc
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		IOManager.output(InputProcessing.processInput(IOManager.getInput("Please enter a command: ")));
	}

}
