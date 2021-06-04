package businessApplication;

public class DistributionCenter {
	
	
	private StorageArea boxedMilkStorage;
	private StorageArea chocolateStorage;
	private StorageArea yogurtStorage;
	


	public DistributionCenter() {
		boxedMilkStorage= new StorageArea();
		chocolateStorage= new StorageArea();
		yogurtStorage= new StorageArea();
	}
	public double sellProducts(double totalMoney,int amount,String whichProduct) 
	{
		if(whichProduct.equalsIgnoreCase("boxed milk")) 
		{
			if(amount>boxedMilkStorage.size()) 
			{
				System.out.println("There is not enough product!");
				return totalMoney;
			}
			int amountLeft=amount;
			while(amountLeft!=0)
			{
				boxedMilkStorage.remove();
				totalMoney=totalMoney+1;
				amountLeft--;
				
			}
			
		}
		else if(whichProduct.equalsIgnoreCase("chocolate")) 
		{
			if(amount>chocolateStorage.size()) 
			{
				System.out.println("There is not enough product!");
				return totalMoney;
			}
			int amountLeft=amount;
			while(amountLeft!=0)
			{
				chocolateStorage.remove();
				totalMoney=totalMoney+4;
				amountLeft--;
				
			}
		}
		else if(whichProduct.equalsIgnoreCase("yogurt")) 
		{
			if(amount>yogurtStorage.size()) 
			{
				System.out.println("There is not enough product!");
				return totalMoney;
			}
			int amountLeft=amount;
			while(amountLeft!=0)
			{
				yogurtStorage.remove();
				totalMoney=totalMoney+2;
				amountLeft--;
				
			}
		}
		
		

		
		
		return totalMoney;
	}
	public boolean addProduct(Countable e) 
	{
		
		if(e instanceof BoxedMilk) 
		{
			return boxedMilkStorage.add(e);
		}
		else if(e instanceof Chocolate) 
		{
			return chocolateStorage.add(e);
		}
		else if(e instanceof Yogurt) 
		{
			return yogurtStorage.add(e);
		}
		else 
			return false;
		
	}
	
	public Countable removeProduct(Countable e) 
	{
		if(e instanceof Milk) 
		{
			return boxedMilkStorage.remove();
		}
		else if(e instanceof Cream) 
		{
			return chocolateStorage.remove();
		}
		else if(e instanceof Cacao) 
		{
			return yogurtStorage.remove();
		}
		else 
			return null;
	
	}
	@Override
	public String toString() {
		return "DistributionCenter [" + (boxedMilkStorage != null ? "boxedMilkStorage=" + boxedMilkStorage + ", " : "")
				+ (chocolateStorage != null ? "chocolateStorage=" + chocolateStorage + ", " : "")
				+ (yogurtStorage != null ? "yogurtStorage=" + yogurtStorage : "") + "]";
	}
	
	

}
