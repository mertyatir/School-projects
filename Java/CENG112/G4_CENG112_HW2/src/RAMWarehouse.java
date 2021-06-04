
public class RAMWarehouse implements IStack<RAM> {

	private RAM[] products;
	private int top;
	private static int numofproducts;
	
	public RAMWarehouse(int maxSize) 
	{
		products = new RAM[maxSize];
		top = -1;
	}

	public boolean push(RAM newEntry) 
	{
		if (isFull())
			return false;
			top++;
			numofproducts++;
			products[top] = newEntry;
			return true;

	}

	public RAM pop() {
		if (isEmpty())
			return null;
		RAM removed = products[top];
		products[top] = null;
		top--;
		numofproducts--;
		return removed;
	}

	
	public RAM peek() 
	{
		RAM copyitem=products[top];
		return copyitem;
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
