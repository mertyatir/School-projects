
public class CPUWarehouse implements IStack<CPU>
{

	private CPU[] products;
	private int top;
	private static int numofproducts=0;
	
	public CPUWarehouse(int maxSize) 
	{
		products = new CPU[maxSize];
		top = -1;
	}

	public boolean push(CPU newEntry) 
	{
		if (isFull())
			return false;
			top++;
			numofproducts++;
			products[top] = newEntry;
			return true;

	}

	public CPU pop() {
		if (isEmpty())
			return null;
		CPU removed = products[top];
		products[top] = null;
		top--;
		numofproducts--;
		return removed;
	}

	
	public CPU peek() 
	{
		if(isEmpty())
			return null;
		else {
		CPU copyitem=products[top];
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
