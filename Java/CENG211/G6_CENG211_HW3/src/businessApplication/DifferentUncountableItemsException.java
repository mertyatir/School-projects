package businessApplication;

public class DifferentUncountableItemsException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 DifferentUncountableItemsException()
	 {
		 super("Different Uncountable Items!");
	 }
	 
	 DifferentUncountableItemsException(String massage)
	 {
		 super(massage);
	 }

}
