import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO 
{

	private static final String FileName = "CENG112_Homework1_Bags_Inventory.txt";

	
	public static InventoryBag<Item> readInventory() throws IOException
	{
		InventoryBag<Item>  inventoryBag;
		BufferedReader br = null;
		FileReader fr = null; 
		String sCurrentLine;
        Item item;
        int counter=0;
		fr = new FileReader(FileName);
		br = new BufferedReader(fr);
		
        while ((sCurrentLine = br.readLine()) != null)   
        {
        	counter++;
        }
        
        br.close();
        br  = new BufferedReader(new FileReader(FileName));
        	                
        
        inventoryBag = new InventoryBag<Item>(counter);  
		while ((sCurrentLine = br.readLine()) != null) 
		{
		item = new Item();
		String[] splitted = sCurrentLine.split(",");
		item.setName(splitted[0]);
		item.setDisposableType(splitted[1]);
		item.setAmount(Integer.valueOf(splitted[2]));
		inventoryBag.add(item);
		}
	br.close();
		return inventoryBag;
	}
}
