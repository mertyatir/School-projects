package businessApplication;

public class OpenTopContainer extends Container<Uncountable> {

	public boolean add(Object obj) throws DifferentUncountableItemsException
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


}
