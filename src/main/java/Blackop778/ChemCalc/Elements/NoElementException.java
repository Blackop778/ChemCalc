package blackop778.chemcalc.elements;

public class NoElementException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1362039921190575532L;

	public NoElementException()
	{

	}

	public NoElementException(String message)
	{
		super(message);
	}

	public NoElementException(Throwable cause)
	{
		super(cause);
	}

	public NoElementException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public NoElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
