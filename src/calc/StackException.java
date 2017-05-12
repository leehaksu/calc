package calc;

public class StackException extends Exception {
	private static final long serialVersionUID = 1L;

	public StackException()
	{
		super("");
	}
	
	public StackException(String message)
	{
		super(message);
	}

}
