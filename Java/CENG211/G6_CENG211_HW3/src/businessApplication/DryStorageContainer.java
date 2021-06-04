package businessApplication;

public class DryStorageContainer extends Container<Countable> 
{

	public boolean add(Object obj) throws ItemNotCountableException  
	{
	if((obj instanceof Countable))
		{
				return super.addObject((Countable)obj);
		}
	else 
	{
		throw new ItemNotCountableException();
	}
		
	}
}
