package onlineMarketingApplication;

import java.util.*;

public class Customer extends RegularUser{
	
	private Basket basket;
	private ProductInventory<Product> boughtProducts;
	private int freeOfChargeCargo;
	
	
	
	//If the total cost of the bought products by the customer is more than 2000 TL, 
	//the customer’s new shopping will be free of cargo price. 
	//This 2000 TL includes the cost of the bought products prices without cargo prices.
	//For each 2000 TL or more purchases, the customer gains one free of charge cargo.
	
	

	public Customer(String userName, String password, double activeBalance, String telephone, String mail,
			List<Address> addresses) {
		super(userName, password, activeBalance, telephone, mail, addresses);
		this.basket= new Basket();
		this.boughtProducts=new ProductInventory<Product>();
		this.freeOfChargeCargo=0;
	}



	//a customer can add products to the basket or remove products from the basket.
	public void addToBasket(Product product,int quantity) 
	{
		this.basket.addElementToBasket(product, quantity);
	}
	
	public boolean removeFromBasket(Product product,int quantity) 
	{
		return this.basket.removeElementFromInventory(product, quantity);
	}
	
	public double buyProductsInTheBasketAndReturnDecreasedAmount() 
	{
		double totalCost;
		if(this.freeOfChargeCargo>0) 
		{
			totalCost= this.basket.getTotalCost(true);
			this.freeOfChargeCargo--;
		}
		else 
		{
		totalCost= this.basket.getTotalCost();
		}
		
		double activeBalance= this.getActiveBalance();
		
		double decreasedAmount=activeBalance-totalCost;
		
		this.removeActiveBalance(decreasedAmount);
		
		if(isTotalCostOfBoughtProductsMoreThan2000()) 
		{
			this.freeOfChargeCargo++;
		}
		
		moveProductsFromBasketToBoughtProducts();
		
		return decreasedAmount;
	}
	
	public boolean isTotalCostOfBoughtProductsMoreThan2000() 
	{
		return this.boughtProducts.getTotalCost(true)>=2000;
	}




	
	private void moveProductsFromBasketToBoughtProducts() 
	{
		
		
		for (Map.Entry<Product, Integer> entry : this.basket.getInventory().entrySet()) 
		{
			this.boughtProducts.addElementToInventory(entry.getKey(),entry.getValue());
		}
		this.basket.clear();
	}

	


	

}
