
public class StorageChief 
{
    CacheWarehouse cachewarehouse=new CacheWarehouse(500);
    CPUWarehouse cpuwarehouse=new CPUWarehouse(500);
    GraphicsCardWarehouse graphicscardwarehouse=new GraphicsCardWarehouse(500);
    MotherboardWarehouse motherboardwarehouse=new MotherboardWarehouse(500);
    RAMWarehouse ramwarehouse=new RAMWarehouse(500);
	public boolean store(String product,FactoryLine factoryline) 	
	{
		boolean isStored=false;
		if (factoryline.getfront()!=null) 
		{
			if (factoryline.getfront().getname().equalsIgnoreCase("Cache")&& product.equalsIgnoreCase("Cache"))
			{
				Cache currentproduct=(Cache)factoryline.dequeue();
				if(cachewarehouse.push(currentproduct)) 
				{
					System.out.println("Storage Chief storing "+product+" , SUCCESS, "+product+" stored in "+product+" warehouse");
					isStored=true;
				}

			}
			else if (factoryline.getfront().getname().equalsIgnoreCase("CPU")&& product.equalsIgnoreCase("CPU"))
			{
				CPU currentproduct=(CPU) factoryline.dequeue();
				if(cpuwarehouse.push(currentproduct)) 
				{
					System.out.println("Storage Chief storing "+product+" , SUCCESS, "+product+" stored in "+product+" warehouse");
					isStored=true;
				}
			}

			else if (factoryline.getfront().getname().equalsIgnoreCase("GraphicsCard")&& product.equalsIgnoreCase("GraphicsCard"))
			{
				GraphicsCard currentproduct=(GraphicsCard) factoryline.dequeue();
				if(graphicscardwarehouse.push(currentproduct)) 
				{
					System.out.println("Storage Chief storing "+product+" , SUCCESS, "+product+" stored in "+product+" warehouse");
					isStored=true;
				}

			}

			else if (factoryline.getfront().getname().equalsIgnoreCase("Motherboard")&& product.equalsIgnoreCase("Motherboard"))
			{
				Motherboard currentproduct=(Motherboard) factoryline.dequeue();
				if(motherboardwarehouse.push(currentproduct)) 
				{
					System.out.println("Storage Chief storing "+product+" , SUCCESS, "+product+" stored in "+product+" warehouse");
					isStored=true;
				}

			}

			else if (factoryline.getfront().getname().equalsIgnoreCase("RAM")&& product.equalsIgnoreCase("RAM"))
			{
				RAM currentproduct=(RAM) factoryline.dequeue();
				if(ramwarehouse.push(currentproduct)) 
				{
					System.out.println("Storage Chief storing "+product+" , SUCCESS, "+product+" stored in "+product+" warehouse");
					isStored=true;
				}

			}
		}
		else
		{
			System.out.println("Storage Chief storing "+product+", FAIL, There is no " +product+" in factoryline");
		}

		return isStored;
	}
	public CacheWarehouse getCachewarehouse() {
		return cachewarehouse;
	}
	public CPUWarehouse getCpuwarehouse() {
		return cpuwarehouse;
	}
	public GraphicsCardWarehouse getGraphicscardwarehouse() {
		return graphicscardwarehouse;
	}
	public MotherboardWarehouse getMotherboardwarehouse() {
		return motherboardwarehouse;
	}
	public RAMWarehouse getRamwarehouse() {
		return ramwarehouse;
	}



}
