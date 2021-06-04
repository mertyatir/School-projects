package onlineMarketingApplication;

import java.util.*;


public abstract class Inventory<T> implements IInventory<T> {
	protected Map<T,Integer> inventory;

	public Inventory() 
	{
		this.inventory=new HashMap<T, Integer>();
	}
	
	public Inventory(Inventory<T> other) //copy constructor
	{
		this.inventory=other.getInventory();
	}
	
	
	
	public Map<T, Integer> getInventory() //deep copy of inventory. if T is not immutable reference type then this method should be properly overrided
	{
		
		Map<T,Integer> original=this.inventory;
	{
		Map<T,Integer> copy = new HashMap<T,Integer>();
	    for (Map.Entry<T,Integer> entry : original.entrySet())
	    {
	        copy.put(entry.getKey(),entry.getValue());
	    }
	    return copy;
	}
		
	}

}
