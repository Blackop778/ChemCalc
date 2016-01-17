package Blackop778.ChemCalc.Functions;

public class InputReturn
{
	private String returnType;
	private String output;

	public InputReturn(String returnType, String output)
	{
		this.returnType = returnType;
		this.output = output;
	}

	public String getReturnType()
	{
		return returnType;
	}

	public String getOutput()
	{
		return output;
	}
}
