package businessApplication;

public class ItemNotUncountableException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 ItemNotUncountableException()
	 {
		 super("Item Is Not Uncountable!");
	 }
	 
	 ItemNotUncountableException(String massage)
	 {
		 super(massage);
	 }

}
