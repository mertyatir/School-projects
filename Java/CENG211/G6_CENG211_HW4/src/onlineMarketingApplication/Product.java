package onlineMarketingApplication;

public class Product // electronic and houseware for default

{
	
	private String category; 
	private String name;
	private double price; 
	private double weight;
	private double cargoPrice; // weight * 2.0 for electronic and houseware products.
	
	//immutable class
	//should be initialized upon creation


	public Product() //invalid object
	{
		this.category="null";
		this.name="null";
		this.price=-1; 
		this.weight=-1;
		this.cargoPrice=-1;
	}
	
	public Product(String category, String name, double price, double weight,double cargoPriceModifier) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.cargoPrice=this.weight*2*cargoPriceModifier;
	}
	
	public Product(String category, String name, double price, double weight) 
	{
		this(category,name,price,weight,1);
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}

	public double getCargoPrice() {
		return cargoPrice;
	}

	public String toString() {
		return name;
	}


	
	
	
	
}
