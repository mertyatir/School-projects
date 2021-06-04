package onlineMarketingApplication;

import java.util.Map;

public class Shop {
	
	private Inventory<Product> inventory;
	
	//The products should be added to the shop inventories according to the category of the products and the category of the shops.
	//For example, the cosmetic products should be in the cosmetic shop.

	public Shop() 
	{
		this.inventory= new ProductInventory<Product>();
	}
	
	public  Shop(Shop other) 
	{
		this.inventory=other.getInventory();
	}

	public void addElementToShop(Product key, int value) {
		this.inventory.addElementToInventory(key, value);
	}

	public boolean removeElementFromShop(Product key, int value) {
		return this.inventory.removeElementFromInventory(key, value);
	}

	public Inventory<Product> getInventory() 
	{
		return inventory;
	}

	public void setInventory(Inventory<Product> inventory) {
		this.inventory = inventory;
	}
	
	



}
