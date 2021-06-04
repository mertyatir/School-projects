package businessApplication;

public class StorageArea extends Storage<Countable>
{

	public StorageArea()
	{
		super();
	}
	public String toString() 
	{
		int amount=0;
		Object[] array=super.getStoredItem().toArray();
		for (Object object : array) 
		{
			if(object!=null) {
				amount++;
			}
			
		}
		return amount+" piece";
	}

}
