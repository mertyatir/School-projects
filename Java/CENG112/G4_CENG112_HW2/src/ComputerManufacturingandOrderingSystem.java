import java.util.*;



public class ComputerManufacturingandOrderingSystem {

	public static void main(String[] args) {
		String product;
		Random random = new Random();
		System.out.println("Enter the number of random request cycles:");
        Scanner input = new Scanner(System.in);
        MarketingAnalyst marketinganalyst= new MarketingAnalyst();
        StorageChief storagechief= new StorageChief();
        Customer customer = new Customer();
        FactoryLine factoryline= new FactoryLine(500);
		CacheWarehouse cachewarehouse=new CacheWarehouse(500);
		CPUWarehouse cpuwarehouse=new CPUWarehouse(500);
        GraphicsCardWarehouse graphicscardwarehouse= new GraphicsCardWarehouse(500);
        MotherboardWarehouse motherboardwarehouse=new MotherboardWarehouse(500);
        RAMWarehouse ramwarehouse=new RAMWarehouse(500);
        
	    int numofcyles = input.nextInt();
	
		  String[] products= {"RAM", "CPU", "GraphicsCard", "Motherboard", "Cache"};
		  while(numofcyles!=0) 
		  {
			  int r1 = random.nextInt(3);
			  if (r1==0) 
			  {
				  int r2= random.nextInt(5);
				  product = products[r2];
				  marketinganalyst.order(product);
				  factoryline=marketinganalyst.getfactoryline();
			  }
			  if (r1 == 1) 
			  {
				  int r2= random.nextInt(5);
				  product = products[r2];
				  if(factoryline==null)
				  {
					  System.out.println("Storage Chief storing "+product+", FAIL, Factory Line is empty");
				  }
				  else if(storagechief.store(product,factoryline))
				  {
				  cachewarehouse=storagechief.getCachewarehouse();
				  cpuwarehouse=storagechief.getCpuwarehouse();
				  graphicscardwarehouse=storagechief.getGraphicscardwarehouse();
				  motherboardwarehouse=storagechief.getMotherboardwarehouse();
				  ramwarehouse=storagechief.getRamwarehouse();
				  }
				  else
					  System.out.println("Storage Chief storing "+product+", FAIL, There is no " +product+" in factoryline");
			  }
			  if(r1 == 2) 
			  {
				  int r2= random.nextInt(5);
				  product = products[r2];
				  customer.buy(product,cachewarehouse,cpuwarehouse,graphicscardwarehouse,motherboardwarehouse,ramwarehouse);
			  }
			  product = null;
			  numofcyles--;
		  }
		  input.close();
		  System.out.println("\n"+"REPORT:"+"\n"+
			  "Amount of RAM in Factory Line: "+String.valueOf(factoryline.numberofram)+ "\n"+
			  "Amount of CPU in Factory Line: "+String.valueOf(factoryline.numberofcpu)+ "\n"+
			  "Amount of Graphics Card in Factory Line: "+String.valueOf(factoryline.numberofgraphicscard)+"\n"+
			  "Amount of Motherboard in Factory Line: "+String.valueOf(factoryline.numberofmotherboard)+"\n"+
			  "Amount of Cache in Factory Line: "+String.valueOf(factoryline.numberofcache)+"\n"+"\n"+
			  
			  "Amount of RAM in RAM Warehouse: "+String.valueOf(ramwarehouse.getNumofproducts()) +"\n"+
			  "Amount of CPU in CPU Warehouse: "+String.valueOf(cpuwarehouse.getNumofproducts()) +"\n"+
			  "Amount of Graphics Card in Graphics Card Warehouse: " +String.valueOf(graphicscardwarehouse.getNumofproducts()) +"\n"+
			  "Amount of Motherboard in Motherboard Warehouse: "+String.valueOf(motherboardwarehouse.getNumofproducts())     + "\n"+
			  "Amount of Cache in Cache Warehouse: "+String.valueOf(cachewarehouse.getNumofproducts()) +"\n" +"\n"+
			  
			  "Amount of RAM Sold: "+String.valueOf(customer.numberoframsold)+"\n"+
			  "Amount of CPU Sold: "+String.valueOf(customer.numberofcpusold)+"\n"+
			  "Amount of Graphics Card Sold: "+String.valueOf(customer.numberofgraphicscardsold)+"\n"+
			  "Amount of Motherboard Sold: " +String.valueOf(customer.numberofmotherboardsold)+"\n"+
			  "Amount of Cache Sold: "+String.valueOf(customer.numberofcachesold));

	}

}
