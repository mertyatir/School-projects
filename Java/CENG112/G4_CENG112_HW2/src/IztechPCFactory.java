
public class IztechPCFactory
{
	FactoryLine factoryline= new FactoryLine(100);
	static Integer idnumbergeneretor=0;
	public boolean manufacture(String product) 
	{
		boolean isManufactured=false;
		
		if(product=="RAM") 
		{
			IProduct RAM= new RAM(idnumbergeneretor);
			isManufactured=factoryline.enqueue(RAM);
			if(isManufactured) 
			{
				RAM.setLocation("FactoryLine");
				idnumbergeneretor++;
			}
				
		}
		if(product=="CPU") 
		{
			IProduct CPU= new CPU(idnumbergeneretor);
			 isManufactured=factoryline.enqueue(CPU);
			 if(isManufactured) 
				{
					CPU.setLocation("FactoryLine");
					idnumbergeneretor++;
				}
		}
		if(product=="GraphicsCard") 
		{
			IProduct graphicscard= new GraphicsCard(idnumbergeneretor);
			 isManufactured=factoryline.enqueue(graphicscard);
			 if(isManufactured) 
				{
				    graphicscard.setLocation("FactoryLine");
					idnumbergeneretor++;
				}
		}
		if(product=="Motherboard") 
		{
			IProduct Motherboard= new  Motherboard(idnumbergeneretor);
			 isManufactured=factoryline.enqueue(Motherboard);
			 if(isManufactured) 
				{
				    Motherboard.setLocation("FactoryLine");
					idnumbergeneretor++;
				}
		}
		
		if(product=="Cache") 
		{
			IProduct Cache= new  Cache(idnumbergeneretor);
			 isManufactured=factoryline.enqueue(Cache);
			 if(isManufactured) 
				{
				    Cache.setLocation("FactoryLine");
					idnumbergeneretor++;
				}
		}
		return isManufactured;
	}
	public FactoryLine getfactoryline() {
		return this.factoryline;
	}

	
}
