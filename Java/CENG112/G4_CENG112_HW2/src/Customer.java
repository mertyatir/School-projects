
public class Customer 
{
	public int numberofcachesold=0;
	public int numberofcpusold=0;
	public int numberofgraphicscardsold=0;
	public int numberofmotherboardsold=0;
	public int numberoframsold=0;

	public void buy(String product, CacheWarehouse cachewarehouse, CPUWarehouse cpuwarehouse, GraphicsCardWarehouse graphicscardwarehouse, MotherboardWarehouse motherboardwarehouse, RAMWarehouse ramwarehouse) 
	{
		if(cachewarehouse!=null && !(cachewarehouse.isEmpty()) && cachewarehouse.peek().getname().equalsIgnoreCase(product)) 
		{
			cachewarehouse.pop();
			numberofcachesold++;
			System.out.println("Customer buying "+product+", SUCCESS, Customer bought "+product);
			
		}
		else if(cpuwarehouse!=null && !(cpuwarehouse.isEmpty()) && cpuwarehouse.peek().getname().equalsIgnoreCase(product)) 
		{
			cpuwarehouse.pop();
			numberofcpusold++;
			System.out.println("Customer buying "+product+", SUCCESS, Customer bought "+product);

		}

		else if(graphicscardwarehouse!=null &&!(graphicscardwarehouse.isEmpty()) && graphicscardwarehouse.peek().getname().equalsIgnoreCase(product)) 
		{
			graphicscardwarehouse.pop();
			numberofgraphicscardsold++;
			System.out.println("Customer buying "+product+", SUCCESS, Customer bought "+product);

		}

		else if(motherboardwarehouse!=null &&!(motherboardwarehouse.isEmpty()) && motherboardwarehouse.peek().getname().equalsIgnoreCase(product)) 
		{
			motherboardwarehouse.pop();
			numberofmotherboardsold++;
			System.out.println("Customer buying "+product+", SUCCESS, Customer bought "+product);

		}

		else if(ramwarehouse!=null &&!(ramwarehouse.isEmpty()) && ramwarehouse.peek().getname().equalsIgnoreCase(product)) 
		{
			ramwarehouse.pop();
			numberoframsold++;
			System.out.println("Customer buying "+product+", SUCCESS, Customer bought "+product);

		}
		else
		{
			System.out.println("Customer buying "+product+", FAIL, "+product+" warehouse empty");
		}
			

		
	}

}
