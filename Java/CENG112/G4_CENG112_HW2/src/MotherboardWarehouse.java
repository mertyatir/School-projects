
public class MotherboardWarehouse implements IStack<Motherboard>{

	private Motherboard[] products;
	private int top;
	private static int numofproducts=0;
	
	public MotherboardWarehouse(int maxSize) 
	{
		products = new Motherboard[maxSize];
		top = -1;
	}

	public boolean push(Motherboard newEntry) 
	{
		if (isFull())
			return false;
			top++;
			numofproducts++;
			products[top] = newEntry;
			return true;

	}

	public Motherboard pop() {
		if (isEmpty())
			return null;
		Motherboard removed = products[top];
		products[top] = null;
		top--;
		numofproducts--;
		return removed;
	}

	
	public Motherboard peek() 
	{
		Motherboard copyitem=products[top];
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
