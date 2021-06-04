
public class CacheWarehouse implements IStack<Cache>
{
	private Cache[] products;
	private int top;
	private static int numofproducts=0;
	
	public CacheWarehouse(int maxSize) 
	{
		products = new Cache[maxSize];
		top = -1;
	}

	public boolean push(Cache newEntry) 
	{
		if (isFull())
			return false;
			top++;
			numofproducts++;
			products[top] = newEntry;
			return true;

	}

	public Cache pop() {
		if (isEmpty())
			return null;
		Cache removed = products[top];
		products[top] = null;
		top--;
		numofproducts--;
		return removed;
	}

	
	public Cache peek() 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
		Cache copyitem=products[top];
		return copyitem;
		}
	}

	
	public boolean isEmpty() 
	{
		return (top == -1);
	}
	
	public boolean isFull() 
	{
		return (top == products.length - 1);
	}

	public int getNumofproducts() {
		return numofproducts;
	}
}


