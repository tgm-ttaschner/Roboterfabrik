package build;

@SuppressWarnings("serial")
public class NotEnoughArgumentsException extends Exception {
	public String getMessage()	{
		return "Too few arguments!";
	}
}
