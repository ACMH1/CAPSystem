package exception;

public class NoDataException extends Exception
{
	public NoDataException()
	{
	}

	public NoDataException(String s)
	{
		super(s);
	}

	public NoDataException(Exception e)
	{
		super(e);
	}
}
