package businessApplication;

public class Factory {
	
	private StorageTank milkStorage;
	private StorageTank creamStorage;
	private StorageTank cacaoStorage;
	private StorageTank yeastStorage;
	
	private StorageArea boxedMilkStorage;
	private StorageArea chocolateStorage;
	private StorageArea yogurtStorage;
	
	
	public Factory() 
	{
		milkStorage= new StorageTank();
		creamStorage= new StorageTank();
		cacaoStorage=new StorageTank();
		yeastStorage= new StorageTank();
		
		milkStorage.add(new Milk());
		creamStorage.add(new Cream());
		cacaoStorage.add(new Cacao());
		yeastStorage.add(new Yeast());
		
		boxedMilkStorage= new StorageArea();
		chocolateStorage= new StorageArea();
		yogurtStorage= new StorageArea();
		
	}
	
	public void produceProduct(String whichProduct) 
	{
		if(whichProduct.equalsIgnoreCase("BoxedMilk")) 
		{
				if (milkStorage.peek().getAmount()<1000)
				{
					System.out.println("Not enough ingredients!");
				}
				else 
				{
					
					Uncountable milk=milkStorage.remove();
					int amountLeft= milk.getAmount()-1000;
					milk.setAmount(amountLeft);
					milkStorage.add(milk);
					int i=1000;
					while(i!=0) 
					{
						boxedMilkStorage.add(new BoxedMilk());
						i--;
					}
				}
				
			}
			
		
		else if(whichProduct.equalsIgnoreCase("Chocolate")) 
		{
			if (milkStorage.peek().getAmount()<500||creamStorage.peek().getAmount()<200 ||cacaoStorage.peek().getAmount()<300)
			{
				System.out.println("Not enough ingredients!");
			}
			else 
			{
				
				Uncountable milk=milkStorage.remove();
				Uncountable cream=creamStorage.remove();
				Uncountable cacao= cacaoStorage.remove();
				
				int milkAmountLeft= milk.getAmount()-500;
				int creamAmountLeft= cream.getAmount()-200;
				int cacaoAmountLeft= cacao.getAmount()-300;
				
				milk.setAmount(milkAmountLeft);
				milkStorage.add(milk);
				
				cream.setAmount(creamAmountLeft);
				creamStorage.add(cream);
				
				cacao.setAmount(cacaoAmountLeft);
				cacaoStorage.add(cacao);
				
				
				int i=1600;
				while(i!=0) 
				{
					chocolateStorage.add(new Chocolate());
					i--;
				}
			}
			
	
			
		}
		else if(whichProduct.equalsIgnoreCase("Yogurt")) 
		{
			if (milkStorage.peek().getAmount()<1500||yeastStorage.peek().getAmount()<100)
			{
				System.out.println("Not enough ingredients!");
			}
			else 
			{
				
				Uncountable milk=milkStorage.remove();
				Uncountable yeast=yeastStorage.remove();
			
				
				int milkAmountLeft= milk.getAmount()-1500;
				int yeastAmountLeft= yeast.getAmount()-100;
			
				
				milk.setAmount(milkAmountLeft);
				milkStorage.add(milk);
				
				yeast.setAmount(yeastAmountLeft);
				yeastStorage.add(yeast);
				
		
				
				
				int i=700;
				while(i!=0) 
				{
					yogurtStorage.add(new Yogurt());
					i--;
				}
			}
			
		}
		
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
	
	public boolean addIngredient(Uncountable e) 
	{
		if(e instanceof Milk) 
		{
			int amount=e.getAmount();
			milkStorage.peek().setAmount(milkStorage.peek().getAmount()+amount);
			Milk milk= new Milk();
			milk.setAmount(amount);
			return true;
		}
		else if(e instanceof Cream) 
		{
			int amount=e.getAmount();
			creamStorage.peek().setAmount(creamStorage.peek().getAmount()+amount);
			Cream cream= new Cream();
			cream.setAmount(amount);
			return true;
		}
		else if(e instanceof Cacao) 
		{
			int amount=e.getAmount();
			cacaoStorage.peek().setAmount(cacaoStorage.peek().getAmount()+amount);
			Cacao cacao= new Cacao();
			cacao.setAmount(amount);
			return true;
		}
		else if(e instanceof Yeast) 
		{
			int amount=e.getAmount();
			yeastStorage.peek().setAmount(yeastStorage.peek().getAmount()+amount);
			Yeast yeast= new Yeast();
			yeast.setAmount(amount);
			return true;
		}
		else 
			return false;
	}
	
	public Uncountable removeIngredient(Uncountable e) 
	{
		if(e instanceof Milk) 
		{
			int amount=e.getAmount();
			milkStorage.peek().setAmount(milkStorage.peek().getAmount()-amount);
			Milk milk= new Milk();
			milk.setAmount(amount);
			return milk;
		}
		else if(e instanceof Cream) 
		{
			int amount=e.getAmount();
			creamStorage.peek().setAmount(creamStorage.peek().getAmount()-amount);
			Cream cream= new Cream();
			cream.setAmount(amount);
			return cream;
		}
		else if(e instanceof Cacao) 
		{
			int amount=e.getAmount();
			cacaoStorage.peek().setAmount(cacaoStorage.peek().getAmount()-amount);
			Cacao cacao= new Cacao();
			cacao.setAmount(amount);
			return cacao;
		}
		else if(e instanceof Yeast) 
		{
			int amount=e.getAmount();
			yeastStorage.peek().setAmount(yeastStorage.peek().getAmount()-amount);
			Yeast yeast= new Yeast();
			yeast.setAmount(amount);
			return yeast;
		}
		else 
			return null;
	
	}
	
	public Countable removeProduct(Countable e) 
	{
		if(e instanceof BoxedMilk) 
		{
			return boxedMilkStorage.remove();
		}
		else if(e instanceof Chocolate) 
		{
			return chocolateStorage.remove();
		}
		else if(e instanceof Yogurt) 
		{
			return yogurtStorage.remove();
		}
		else 
			return null;
	
	}

	@Override
	public String toString() {
		return "Factory [" + (milkStorage != null ? "milkStorage=" + milkStorage + ", " : "")
				+ (creamStorage != null ? "creamStorage=" + creamStorage + ", " : "")
				+ (cacaoStorage != null ? "cacaoStorage=" + cacaoStorage + ", " : "")
				+ (yeastStorage != null ? "yeastStorage=" + yeastStorage + ", " : "")
				+ (boxedMilkStorage != null ? "boxedMilkStorage=" + boxedMilkStorage + ", " : "")
				+ (chocolateStorage != null ? "chocolateStorage=" + chocolateStorage + ", " : "")
				+ (yogurtStorage != null ? "yogurtStorage=" + yogurtStorage : "") + "]";
	}
	
	
	
	
}
