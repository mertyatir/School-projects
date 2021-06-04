package businessApplication;

public class ControlCenter implements IControl
{
	private DryStorageContainer dryStorageContainer;
	private OpenTopContainer openTopContainer;
	private TankContainer tankContainer;
	
	private Warehouse warehouse;
	private Factory factory;
	private DistributionCenter distributionCenter;
	private double totalMoney=10000;
	
	
	
	
	ControlCenter()
	{
		dryStorageContainer=new DryStorageContainer();
		openTopContainer= new OpenTopContainer();
		 tankContainer= new TankContainer();
		 
		 
		 warehouse= new Warehouse();
		 factory= new Factory();
		 distributionCenter= new DistributionCenter();
	}

	public void transferTo(String itemToBeTransfered, String start, String end, String container)
			throws ItemNotCountableException, ItemNotUncountableException, DifferentUncountableItemsException {
		
		Countable product=null;
		Uncountable ingredient=null;
		
		
		
		
		if(itemToBeTransfered.equalsIgnoreCase("Milk")) 
		{
			ingredient= new Milk();
		}
		else if(itemToBeTransfered.equalsIgnoreCase("Cream")) 
		{
			ingredient= new Cream();
		}
		else if(itemToBeTransfered.equalsIgnoreCase("Cacao")) 
		{
			ingredient= new Cacao();
		}
		else if(itemToBeTransfered.equalsIgnoreCase("Yeast")) 
		{
			ingredient= new Yeast();
		}
		else if(itemToBeTransfered.equalsIgnoreCase("Boxed Milk")||itemToBeTransfered.equalsIgnoreCase("BoxedMilk")) 
		{
			product= new BoxedMilk();
		}
		else if(itemToBeTransfered.equalsIgnoreCase("Chocolate")) 
		{
			product= new Chocolate();
		}
		else if(itemToBeTransfered.equalsIgnoreCase("Yogurt")) 
		{
			product= new Yogurt();
		}
		else 
		{
			System.out.println("There is no ingredient/product named: "+itemToBeTransfered);
		}
		
		
		if((container.equalsIgnoreCase("DryStorageContainer"))||(container.equalsIgnoreCase("Dry Storage Container")))
		{
			if(product!=null) //Countable
			{
				
				if(start.equalsIgnoreCase("Warehouse")) 
				{
					System.out.println("Wrong start position.Select Factory or DistributionCenter");
				}
				else if(start.equalsIgnoreCase("Factory")) 
				{
					if(!(dryStorageContainer.getLocation().equalsIgnoreCase(start))) 
					{
						totalMoney= totalMoney-100;
						dryStorageContainer.setLocation(start);
					}
					int amountToBeStored=1000;
					if(product instanceof BoxedMilk) 
					{
						while(amountToBeStored!=0) 
						{
							dryStorageContainer.push(factory.removeProduct(new BoxedMilk()));
							amountToBeStored--;
						}
					}
					else if(product instanceof Chocolate) 
					{
						while(amountToBeStored!=0) 
						{
							dryStorageContainer.push(factory.removeProduct(new Chocolate()));
							amountToBeStored--;
						}
					}
					else if(product instanceof Yogurt) 
					{
						amountToBeStored= amountToBeStored/2;
						while(amountToBeStored!=0) 
						{
							dryStorageContainer.push(factory.removeProduct(new Yogurt()));
							amountToBeStored--;
						}
					}
				}
				else if(start.equalsIgnoreCase("DistributionCenter")) 
				{
					if(!(dryStorageContainer.getLocation().equalsIgnoreCase(start))) 
					{
						totalMoney= totalMoney-100;
						dryStorageContainer.setLocation(start);
					}
					int amountToBeStored=1000;
					if(product instanceof BoxedMilk) 
					{
						while(amountToBeStored!=0) 
						{
							dryStorageContainer.push(distributionCenter.removeProduct(new BoxedMilk()));
							amountToBeStored--;
						}
					}
					else if(product instanceof Chocolate) 
					{
						amountToBeStored= amountToBeStored*2;
						while(amountToBeStored!=0) 
						{
							dryStorageContainer.push(distributionCenter.removeProduct(new Chocolate()));
							amountToBeStored--;
						}
					}
					else if(product instanceof Yogurt) 
					{
						amountToBeStored= amountToBeStored/2;
						while(amountToBeStored!=0) 
						{
							dryStorageContainer.push(distributionCenter.removeProduct(new Yogurt()));
							amountToBeStored--;
						}
					}
				}
				else
					System.out.println("There is no location named "+start );
	
				
				if(end.equalsIgnoreCase("Warehouse")) 
				{
					System.out.println("There is no point to go to "+ end+" when you are carrying Countable items");
				}
				else if(end.equalsIgnoreCase("Factory")) 
				{
					System.out.println("There is no point to go to "+ end+" when you are carrying Countable items");
				}
				else if(end.equalsIgnoreCase("DistributionCenter")|| end.equalsIgnoreCase("Distribution Center")) 
				{
					while(!(dryStorageContainer.isEmpty())) 
					{
						distributionCenter.addProduct(dryStorageContainer.pop());
					}
					dryStorageContainer.setLocation(end);
					totalMoney= totalMoney-100;
				}
				else {
					System.out.println("There is no location called: "+end);
				}

			}
			else 
			{
				throw new ItemNotCountableException();
			}
			
		}
		else if((container.equalsIgnoreCase("OpenTopContainer"))||(container.equalsIgnoreCase("Open Top Container")))
		{
			if(ingredient!=null) //Uncountable
			{
               if(start.equalsIgnoreCase("Warehouse")) 
               {
   				if(!(openTopContainer.getLocation().equalsIgnoreCase(start))) 
   				{
   					totalMoney= totalMoney-100;
   					openTopContainer.setLocation(start);
   				}
   				
   				if(ingredient instanceof Yeast) 
   				{
					int amount=warehouse.numOfYeast();
					if(amount==0) 
					{
						System.out.println("There is no Yeast to transfer");
						totalMoney= totalMoney+100;
						return;
					}
					else if(amount>1000) 
					{
						amount=1000;
					}
					ingredient.setAmount(amount);
   					openTopContainer.push(warehouse.removeIngredient(ingredient));
   				}
   				else if(ingredient instanceof Cacao)
   				{
					int amount=warehouse.numOfCacao();
					if(amount==0) 
					{
						System.out.println("There is no Cacao to transfer");
						totalMoney= totalMoney+100;
						return;
					}
					else if(amount>1000) 
					{
						amount=1000;
					}
					ingredient.setAmount(amount);
   					openTopContainer.push(warehouse.removeIngredient(ingredient));
   				}
   				else {
   					throw new DifferentUncountableItemsException();
   				}
               }
               else if(start.equalsIgnoreCase("Factory")) 
				{
     				if(!(openTopContainer.getLocation().equalsIgnoreCase(start))) 
       				{
       					totalMoney= totalMoney-100;
       					openTopContainer.setLocation(start);
       				}
       				
       				if(ingredient instanceof Yeast) 
       				{
       					
       					openTopContainer.push(factory.removeIngredient(ingredient));
       					
       				}
       				else if(ingredient instanceof Cacao)
       				{
       
       					openTopContainer.push(factory.removeIngredient(ingredient));
       				}
       				else {
       					throw new DifferentUncountableItemsException();
       				}
				}
           	else if(start.equalsIgnoreCase("DistributionCenter")) 
			{
           		System.out.println("Wrong start position.Select Factory or Warehouse");
			}
           	else {
           		System.out.println("Invalid start location: "+start);
           	}
           	if(end.equalsIgnoreCase("Warehouse")) 
			{
				System.out.println("There is no point to go to "+ end+" when you are carrying Uncountable items");
			}
			else if(end.equalsIgnoreCase("Factory")) 
			{
				factory.addIngredient(openTopContainer.pop());
				openTopContainer.setLocation(end);
				totalMoney= totalMoney-100;
			}
			else if(end.equalsIgnoreCase("DistributionCenter")|| end.equalsIgnoreCase("Distribution Center")) 
			{
				System.out.println("There is no point to go to "+ end+" when you are carrying Unountable items");
				
		
			}
			else {
				System.out.println("There is no location called: "+end);
			}
                 
             
			}
			

               
			else 
			{
				throw new ItemNotUncountableException();
			}
		}
		else if((container.equalsIgnoreCase("TankContainer"))||(container.equalsIgnoreCase("Tank Container")))
		{
			if(ingredient!=null) //Uncountable
			{
				if(!(tankContainer.getLocation().equalsIgnoreCase(start))) 
				{
					totalMoney= totalMoney-100;
					tankContainer.setLocation(start);
				}
				
				if(ingredient instanceof Milk) 
				{
					
					int amount=warehouse.numOfMilk();
					if(amount==0) 
					{
						System.out.println("There is no Milk to transfer");
						totalMoney= totalMoney+100;
						return;
					}
					else if(amount>1000) 
					{
						amount=1000;
					}
					ingredient.setAmount(amount);
					tankContainer.push(ingredient);
					warehouse.removeIngredient(ingredient);
					
				}
				else if(ingredient instanceof Cream)
				{
					int amount=warehouse.numOfCream();
					if(amount==0) 
					{
						System.out.println("There is no Cream to transfer");
						totalMoney= totalMoney+100;
						return;
					}
					else if(amount>1000) 
					{
						amount=1000;
					}
					ingredient.setAmount(amount);
					tankContainer.push(ingredient);
					warehouse.removeIngredient(ingredient);

				}
				else {
					throw new DifferentUncountableItemsException();
				}
				
				if(end.equalsIgnoreCase("Warehouse")) 
				{
					System.out.println("There is no point to go to "+ end+" when you are carrying Uncountable items");
				}
				else if(end.equalsIgnoreCase("Factory")) 
				{
					factory.addIngredient(tankContainer.pop());
					tankContainer.setLocation(end);
					totalMoney= totalMoney-100;
				}
				else if(end.equalsIgnoreCase("DistributionCenter")|| end.equalsIgnoreCase("Distribution Center")) 
				{
					System.out.println("There is no point to go to "+ end+" when you are carrying Unountable items");
					
			
				}
				else {
					System.out.println("There is no location called: "+end);
				}
	                 

			}
			else 
			{
				throw new ItemNotUncountableException();
			}
		
		}
	
		else {
			System.out.println("There is no container named: "+ container);
		}
	}
	




	public void buyIngredients(int amount, String whichIngredient) {
		this.totalMoney=warehouse.buyIngredients(totalMoney, amount, whichIngredient);
		
	}

	public void sellProducts(int amount, String whichProduct) {
		this.totalMoney=distributionCenter.sellProducts(totalMoney, amount, whichProduct);
		
	}

	public void produceProduct(String whichProduct) 
	{
		factory.produceProduct(whichProduct);
	}


	public void printEverything() 
	{
		System.out.println("\nTotal Money: "+ this.totalMoney +"\nWarehouse: "+warehouse.toString()+"\nFactory: "+factory.toString()+"\nDistribution Center: "+distributionCenter.toString()+"\n");
	}


	

}
