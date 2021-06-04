package onlineMarketingApplication;

import java.util.*;
import java.util.Map.Entry;


public class ProductInventory<T extends Product> extends Inventory<T> 
{
		

	
	public Product findProduct(String productName)  throws ProductNotFoundException
	{
		boolean found=false;
		T tempKey=null;
		for (T key : this.inventory.keySet()) 
		{
			if(key.getName().equalsIgnoreCase(productName)) 
			{
				found=true;
				tempKey=key;
				break;
			}
		}
		if(found) 
		{
			return tempKey; // should not be a problem since Product is immmutable 
		}
		else 
			throw new ProductNotFoundException();
			
	}
	
	
	
	
	public void addElementToInventory(T product ,int quantity) 
	{
		try 
		{
			this.findProduct(product.getName());
			int currentQuantity= this.inventory.get(product);
			int newQuantity= currentQuantity+quantity;
			this.inventory.put(product, newQuantity);
			System.out.println("Product: " +product.getName()+" previous quantity: "+ currentQuantity+" new quantity: "+ newQuantity);
			
		} catch (ProductNotFoundException e) 
		{
			this.inventory.put(product, quantity);
		}
	}


	public boolean removeElementFromInventory(T product, int quantity) 
	{
		try 
		{
			this.findProduct(product.getName());
			int currentQuantity= this.inventory.get(product);
			int newQuantity= currentQuantity-quantity;
			if(newQuantity<0) 
			{
				System.out.println("There are "+currentQuantity+" "+ product.getName()+"s in Inventory but you want to remove " + newQuantity+" from it!");
				return false;
			}
			else 
			{
				
				System.out.println("Previous Quantity: "+ inventory.put(product, newQuantity)+" New value: "+ newQuantity );
				return true;
			}
			
		} catch (ProductNotFoundException e) 
		{
			System.out.println(e.getMessage());
			return false;
		}
		
	}


	public double getTotalCost() 
	{
		double totalCost=0;
		for (Map.Entry<T,Integer> entry : inventory.entrySet())
		{
			totalCost=totalCost+ entry.getKey().getCargoPrice()+entry.getKey().getPrice();
		}
		return totalCost;
	}
	
	public double getTotalCost(boolean isItWithoutCargoPrices) 
	{
		double totalCost=0;
		for (Map.Entry<T,Integer> entry : inventory.entrySet())
		{
			totalCost=totalCost+entry.getKey().getPrice();
		}
		return totalCost;
	}
	
	public void clear() 
	{
		this.inventory.clear();
		
	}
	
	public boolean contains(T product) 
	{
		return this.inventory.containsKey(product);
	}
	
	
	public String toString() 
	{
		String string="";
		
		int i=0;
			
		for (Entry<T,Integer> entry : this.inventory.entrySet()) 
		{
			string=string+ i+" "+entry.getKey()+" "+entry.getValue()+" \n";
			
			i++;
		}
		
		
		return string;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
