package businessApplication;

public class Warehouse {
	
	private StorageTank milkStorage;
	private StorageTank creamStorage;
	private StorageTank cacaoStorage;
	private StorageTank yeastStorage;
	
	public Warehouse() 
	{
		this.milkStorage= new StorageTank();
		milkStorage.add(new Milk());
		this.creamStorage= new StorageTank();
		creamStorage.add(new Cream());
		this.cacaoStorage= new StorageTank();
		cacaoStorage.add(new Cacao());
		this.yeastStorage= new StorageTank();
		yeastStorage.add(new Yeast());
		
	}
	
	
	public double buyIngredients(double totalMoney,int amount,String whichIngredient) 
	{

			if(whichIngredient.equalsIgnoreCase("milk")) 
			{
				if(amount>(StorageTank.getMaxcapacity()-milkStorage.size())) 
				{
					System.out.println("Not enough room in storage!");
				}
				else if(totalMoney<amount*0.25) 
				{
					System.out.println("Not enough money!");
				}
				else 
				{
					milkStorage.peek().setAmount(milkStorage.peek().getAmount()+amount);
					totalMoney=totalMoney-amount*0.25;
				
				}
			}
			else if(whichIngredient.equalsIgnoreCase("cream")) 
			{
				if(amount>(StorageTank.getMaxcapacity()-creamStorage.size())) 
				{
					System.out.println("Not enough room in storage!");
				}
				else if(totalMoney<amount*0.30) 
				{
					System.out.println("Not enough money!");
				}
				else 
				{
					creamStorage.peek().setAmount(creamStorage.peek().getAmount()+amount);
					totalMoney=totalMoney-amount*0.30;
				}
			}
			else if(whichIngredient.equalsIgnoreCase("cacao")) 
			{
				if(amount>(StorageTank.getMaxcapacity()-cacaoStorage.size())) 
				{
					System.out.println("Not enough room in storage!");
				}
				else if(totalMoney<amount*1) 
				{
					System.out.println("Not enough money!");
				}
				else 
				{
					cacaoStorage.peek().setAmount(cacaoStorage.peek().getAmount()+amount);
					totalMoney=totalMoney-amount*1;
				}
			}
			else if(whichIngredient.equalsIgnoreCase("yeast")) 
			{
				if(amount>(StorageTank.getMaxcapacity()-yeastStorage.size())) 
				{
					System.out.println("Not enough room in storage!");
				}
				else if(totalMoney<amount*5) 
				{
					System.out.println("Not enough money!");
				}
				else 
				{
					yeastStorage.peek().setAmount(yeastStorage.peek().getAmount()+amount);
					totalMoney=totalMoney-amount*5;
				}
			}
				return totalMoney;
		}


	public boolean addIngredient(Uncountable e) 
	{
		if(e instanceof Milk) 
		{
			return milkStorage.add(e);
		}
		else if(e instanceof Cream) 
		{
			return creamStorage.add(e);
		}
		else if(e instanceof Cacao) 
		{
			return cacaoStorage.add(e);
		}
		else if(e instanceof Yeast) 
		{
			return yeastStorage.add(e);
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


	@Override
	public String toString() {
		return "Warehouse [" + (milkStorage != null ? "milkStorage=" + milkStorage.toString() + ", " : "")
				+ (creamStorage != null ? "creamStorage=" + creamStorage.toString() + ", " : "")
				+ (cacaoStorage != null ? "cacaoStorage=" + cacaoStorage.toString() + ", " : "")
				+ (yeastStorage != null ? "yeastStorage=" + yeastStorage.toString() : "") + "]";
	}
	
	public int numOfMilk() 
	{
		return this.milkStorage.peek().getAmount();
	}
	public int numOfCream() 
	{
		return this.creamStorage.peek().getAmount();
	}
	public int numOfCacao() 
	{
		return this.cacaoStorage.peek().getAmount();
	}
	
	public int numOfYeast() 
	{
		return this.yeastStorage.peek().getAmount();
	}
	
	
	
	


	
}
