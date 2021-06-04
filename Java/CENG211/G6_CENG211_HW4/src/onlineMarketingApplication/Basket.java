package onlineMarketingApplication;

import java.util.*;

public class Basket {
	
	private ProductInventory<Product> inventory;

	public Basket() 
	{
		this.inventory=new ProductInventory<Product>();
	}

	public Map<Product,Integer> getInventory() {
		return inventory.getInventory();
	}



	public void addElementToBasket(Product key, int value) {
		this.inventory.addElementToInventory(key, value);
	}

	public boolean removeElementFromInventory(Product key, int value) {
		return this.inventory.removeElementFromInventory(key, value);
	}
	
	public void clear() 
	{
		this.inventory.clear();
	}
	
	public double getTotalCost() 
	{
	
		return inventory.getTotalCost();
	}
	
	
	
	public double getTotalCost(boolean isItWithoutCargoPrices) {
		return inventory.getTotalCost(isItWithoutCargoPrices);
	}

	public boolean contains(Product product) 
	{
		return this.inventory.contains(product);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
