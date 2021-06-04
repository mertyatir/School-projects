package businessApplication;

public class ItemNotCountableException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ItemNotCountableException()
	 {
		 super("Item Is Not Countable!");
	 }
	 
	ItemNotCountableException(String massage)
	 {
		 super(massage);
	 }

}
