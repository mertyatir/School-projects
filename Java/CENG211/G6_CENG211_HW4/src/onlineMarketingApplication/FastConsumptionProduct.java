package onlineMarketingApplication;

public class FastConsumptionProduct extends Product 
{
		//The cosmetic products are fast consumption products
		//cargo price= weight * 2.0 *3.5.

	public FastConsumptionProduct() 
	{
		super();
		
	}
	public FastConsumptionProduct(String category, String name, double price, double weight) {
		super(category, name, price, weight, 3.5);
	}

}
