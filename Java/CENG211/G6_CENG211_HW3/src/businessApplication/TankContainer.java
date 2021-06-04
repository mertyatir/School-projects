package businessApplication;

public class TankContainer extends Container<Uncountable>{

	public boolean add(Object obj) throws ItemNotUncountableException, DifferentUncountableItemsException  
	{
	if((obj instanceof Uncountable))
	{
		if(obj.getClass()==this.peek().getClass())
		{
			return super.addObject((Uncountable)obj);
		}
		else 
		{
			throw new DifferentUncountableItemsException();
		}
		
	}
		
	else 
	{
		throw new ItemNotUncountableException();
	}
		
	}
}

