package Blackop778.ChemCalc.Functions;

public class InputReturn
{
	private String returnType;
	private String output;
	private String[] inputs;
	private String inputType;

	private static final String[] NULLSTRINGS = {null};

	/**
	 * Master constructor. All other constructors point to this one.
	 * 
	 * @param returnType
	 *            What type the return is
	 * @param output
	 *            What the output actually is
	 * @param inputs
	 *            What the inputs were
	 * @param inputType
	 *            What type the input was
	 */
	public InputReturn(String returnType, String output, String[] inputs, String inputType)
	{
		this.inputs = inputs;
		this.returnType = returnType;
		this.output = output;
		this.inputType = inputType;
	}

	public InputReturn(String returnType, String output)
	{
		this(returnType, output, NULLSTRINGS, null);
	}

	public InputReturn(String returnType, String output, String[] inputs)
	{
		this(returnType, output, inputs, null);
	}

	public InputReturn(String returnType, String output, String inputType)
	{
		this(returnType, output, NULLSTRINGS, inputType);
	}

	public String getReturnType()
	{
		return returnType;
	}

	public String getOutput()
	{
		return output;
	}

	public String[] getInputs()
	{
		return inputs;
	}

	public String getInputType()
	{
		return inputType;
	}
}
