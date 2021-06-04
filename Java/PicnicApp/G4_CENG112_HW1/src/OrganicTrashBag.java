
public class OrganicTrashBag implements IBag<Item>
{
	
	
	private Item[] items;
	private int numberoflinesofitems;
	private int size;
	private int numItems;


	public OrganicTrashBag(int maxSize) {
	    if (maxSize <= 0) {
	        throw new IllegalArgumentException("Please enter a integer bigger then 0 for maxSize");
	    }
	    this.items = new Item[maxSize];
	    this.numberoflinesofitems = 0;
	    this.size= maxSize;
	    }

	public boolean consume(Item item, IBag<Item>[] trashBags) 
	{
		String disposabletype=item.getDisposableType();
		if(disposabletype.equalsIgnoreCase("plastic")) {
			this.transferTo(trashBags[0], item);
		}
		if(disposabletype.equalsIgnoreCase("paper")) {
			this.transferTo(trashBags[1], item);
		}
		if(disposabletype.equalsIgnoreCase("organic")) {
			this.transferTo(trashBags[2], item);
		}
		return false;
	}

	public boolean add(Item newItem) {
	    if (newItem == null) {
	        throw new IllegalArgumentException("You can't enter null as a argument");
	    } else if (this.isFull()) 
	    {
	        return false;   
	    } else if(!(this.contains(newItem)))
	    {
	        this.items[this.numberoflinesofitems] = newItem;
	        this.numberoflinesofitems++;
	        numItems++;
	        return true;
	        
	    }
	    else 
	    {
	    	this.items[this.getIndexOf(newItem)].setAmount(this.items[this.getIndexOf(newItem)].getAmount()+1);
	    	numItems++;
			return true;
		}
	}


	public boolean isEmpty() {
		if (numberoflinesofitems==0)
			return true;
		else
		return false;
	}


	public boolean isFull() {
		boolean isfull= true;
		if (this.numItems!=this.size) 
			{
				isfull= false;
			}
		return isfull;
		}
		


	public Item removeByIndex(int index) 
	{
		Item item= this.getItems()[index];
		return this.remove(item);

	}

	public Item remove() 
	{
	    int whichOne = (int)(Math.random() * this.numberoflinesofitems);
	    Item item= this.getItems()[whichOne];
	    
	    return this.remove(item);
	    

	}


	public Item remove(Item item) 
	{
		int indexoftheitem=0;
		Item copyitem=new Item();
	    for (int i = 0; i < this.numItems; i++) 
	    {
	        if (this.items[i].getName().equals(item.getName())) 
	        {
	        	indexoftheitem=i;
	        	break;
	        }
	    }
	        copyitem.setAmount(1);
	        copyitem.setDisposableType(item.getDisposableType());
	        copyitem.setName(item.getName());
	        
	    if (item.getAmount()==1) 
	        {
	    		
	            for (int j = indexoftheitem; j < this.numItems - 1; j++) {
	            	this.items[j] = this.items[j + 1];
	            }
	               this.numberoflinesofitems--;
	       	}
	    else {
	        		items[indexoftheitem].setAmount(items[indexoftheitem].getAmount()-1);
	         }
	            
	            
	            return copyitem;
	        }




	public int getItemCount() 
	{
		
		return this.numberoflinesofitems;

	}


	public int getIndexOf(Item item) 
	{
		int foundit=-1;
		for (int i = 0; i < this.numberoflinesofitems; i++) 
		{
			if (this.items[i].getName().equals(item.getName())) 
			{
				foundit=i;
			}
		}
		return foundit;
		
	}


	public boolean contains(Item item) {
	    for (int i = 0; i < this.numberoflinesofitems; i++) {
	        if (this.items[i].getName().equals(item.getName())) {
	            return true;
	        }
	    }
		return false;
	}


	public void displayItems() 
	{
		for (int i = 0; i < this.numberoflinesofitems; i++) 
		{
			System.out.println( i+1 + "- " +this.items[i].toString());
		}

		
	}


	public void dump() 
	{
		for (int i = 0; i < this.numberoflinesofitems; i++) 
		{
			this.items[i]=null;			
		}
		
	}


	public boolean transferTo(IBag<Item> targetBag, Item item) 
	{
		Item realitem= this.items[this.getIndexOf(item)];
		Item copyitem= new Item();
		copyitem.setDisposableType(realitem.getDisposableType());
		copyitem.setName(realitem.getName());
		copyitem.setAmount(1);
		this.remove(item);
		return (targetBag.add(copyitem));
	}

	public Item[] getItems() {
		return items;
	}

}



