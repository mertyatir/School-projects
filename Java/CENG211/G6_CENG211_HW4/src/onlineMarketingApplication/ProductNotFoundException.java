package onlineMarketingApplication;

public class ProductNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -939508291461267050L;

	public ProductNotFoundException() {
		super("Product not found!");
	}
	public ProductNotFoundException(String message) 
	{
		super(message);
	}

	
	

}
