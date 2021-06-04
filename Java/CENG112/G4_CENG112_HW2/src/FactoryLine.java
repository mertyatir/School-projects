
public class FactoryLine implements IQueue<IProduct>
{
	private IProduct[] products;
	private int front;
	private int rear;
	private int numItems; 
	public int numberofcache=0;
	public int numberofcpu=0;
	public int numberofgraphicscard=0;
	public int numberofmotherboard=0;
	public int numberofram=0;


	public FactoryLine(int maxSize) 
	{
		products = new IProduct[maxSize];
		front = 0;
		rear = -1;
		numItems = 0;
	}
	public boolean enqueue(IProduct newentry) 
	{
		if (isFull()) 
		{
			return false;
		}
		rear = (rear + 1) % products.length;
		products[rear] = newentry;
		numItems++;
		if(newentry.getname().equalsIgnoreCase("Cache"))
			numberofcache++;
		else if(newentry.getname().equalsIgnoreCase("CPU"))
			numberofcpu++;
		else if(newentry.getname().equalsIgnoreCase("GraphicsCard"))
			numberofgraphicscard++;
		else if(newentry.getname().equalsIgnoreCase("Motherboard"))
			numberofmotherboard++;
		else if(newentry.getname().equalsIgnoreCase("RAM"))
			numberofram++;
		return true;
	}

	public IProduct dequeue() 
	{
		if (isEmpty()) 
		{
			return null;
		}
		    IProduct removed = products[front];
			products[front] = null;
			front = (front + 1) % products.length;
			if(removed.getname().equalsIgnoreCase("Cache"))
				numberofcache--;
			else if(removed.getname().equalsIgnoreCase("CPU"))
				numberofcpu--;
			else if(removed.getname().equalsIgnoreCase("GraphicsCard"))
				numberofgraphicscard--;
			else if(removed.getname().equalsIgnoreCase("Motherboard"))
				numberofmotherboard--;
			else if(removed.getname().equalsIgnoreCase("RAM"))
				numberofram--;
			numItems--;
			return removed;
	}

	public IProduct getfront() 
	{
		if (isEmpty())
		{
			return null;
		}
		else 
		{
			IProduct copyitem=products[front];
			return copyitem;
		}
		
	}

	public boolean isEmpty() 
	{
		return (numItems == 0);
	}
	
	public boolean isFull() 
	{
		return (numItems == products.length);
	}
}
