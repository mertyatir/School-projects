
import java.io.IOException;
import java.util.*;

public class PicnicBagApp {


	public static void main(String[] args) throws IOException 
	{
		InventoryBag<Item> inventorybag =  FileIO.readInventory();
		Scanner input  = new Scanner(System.in);
		int chosenValue;
		do {
			System.out.println("\n 1.SMALL \n 2.MEDIUM \n 3.LARGE \n Please choose one of the bag size:");
			chosenValue = input.nextInt();
		} while (!(chosenValue==1 || chosenValue==2 ||  chosenValue==3));
		
	
		int value=0;
		switch(chosenValue) {
		case 1:  
			value=5;
			break;
		case 2:
			value=10;
			break;
		case 3:
			value=15;
			break;
		default: 
			break;
		}
		PicnicBag picnicbag= new PicnicBag(value);
		while(!(picnicbag.isFull())) {
			inventorybag.displayItems();
			System.out.println("Please select the number of the item that you want to add to your picnic bag");
			chosenValue=input.nextInt();
			while (chosenValue>inventorybag.getItemCount() || chosenValue<=0) {
				inventorybag.displayItems();
				System.out.println("You have selected invalid item number. Please select again.");
				chosenValue=input.nextInt();
			}
			inventorybag.transferTo(picnicbag, inventorybag.getItems()[chosenValue-1]);
			
		}
		
		System.out.println("Let the picnic BEGIN!");
		PlasticTrashBag plastictrashbag= new PlasticTrashBag(value);
		PaperTrashBag papertrashbag= new PaperTrashBag(value);
		OrganicTrashBag organictrashbag= new OrganicTrashBag(value);
		@SuppressWarnings("unchecked")
		IBag<Item>[] trashbags= new IBag[3];
		trashbags[0]=plastictrashbag;
		trashbags[1]=papertrashbag;
		trashbags[2]=organictrashbag;
		
		
		while (!(picnicbag.isEmpty())) 
		{
			picnicbag.displayItems();
			System.out.println("Select a item to consume");
			chosenValue = input.nextInt();
			while (chosenValue>picnicbag.getItemCount() || chosenValue<=0 ){
				picnicbag.displayItems();
				System.out.println("You have selected invalid item number. Please select again.");
				chosenValue = input.nextInt();
				
			}
			picnicbag.consume(picnicbag.getItems()[chosenValue-1], trashbags);
		}
		
		System.out.println("Plastic: ");
		trashbags[0].displayItems();
		System.out.println("Paper: ");
		trashbags[1].displayItems();
		System.out.println("Organic: ");
		trashbags[2].displayItems();
		
		plastictrashbag.dump();
		papertrashbag.dump();
		organictrashbag.dump();
		input.close();
	}

}