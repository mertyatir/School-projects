package onlineMarketingApplication;

public class FragileProduct extends Product {
	
	
	//The accessories are fragile products
	//cargo price = weight * 2.0 * 4.5

	public FragileProduct() 
	{
		super();
		
	}
	public FragileProduct(String category, String name, double price, double weight) {
		super(category, name, price, weight, 4.5);
	}

}
