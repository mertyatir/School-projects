
public class GraphicsCardWarehouse implements IStack<GraphicsCard>{

	private GraphicsCard[] products;
	private int top;
	private static int numofproducts=0;
	
	public GraphicsCardWarehouse(int maxSize) 
	{
		products = new GraphicsCard[maxSize];
		top = -1;
	}

	public boolean push(GraphicsCard newEntry) 
	{
		if (isFull())
			return false;
			top++;
			numofproducts++;
			products[top] = newEntry;
			return true;

	}

	public GraphicsCard pop() {
		if (isEmpty())
			return null;
		GraphicsCard removed = products[top];
		products[top] = null;
		top--;
		numofproducts--;
		return removed;
	}

	
	public GraphicsCard peek() 
	{
		GraphicsCard copyitem=products[top];
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
