package businessApplication;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
IControl Controller = new ControlCenter();
Scanner scanner = new Scanner(System.in);

int userInput=999;
int userInput2;
int userInput3;
String start =null;
String end=null ;
String whichIngredient=null;
String whichProduct=null;
String itemToBeTransfered=null;
String container=null;

while(userInput!=0) {
	
	System.out.println("Press -1- for transfer items\nPress -2- for buy ingredients\nPress -3- for sell products\nPress -4- for produce products\nPress -5- for printing all the transactions\nPress -0- to exit");
	userInput = scanner.nextInt();
	switch(userInput) {
	case 1:
		try { 
			System.out.println("Where do you want to transfer item from?");
			System.out.println("Press -1- for Warehouse\nPress -2- for Factory\nPress -3- for Distribution Center");
			userInput2= scanner.nextInt();
			while((userInput2!=1)&(userInput2!=2)&(userInput2!=3)) {
				System.out.println("Press -1- for Warehouse\nPress -2- for Factory\nPress -3- for Distribution Center");
				userInput2= scanner.nextInt();
			}
			
			switch(userInput2) {
			case 1 :
				start = "Warehouse";
				break;
			case 2 : 
				start = "Factory";
				break;
			case 3 :
				start = "DistributionCenter"; 
				break;
			}
			
			switch(start) {
			case "Warehouse" :
				System.out.println("Your container is going to the Factory!");
				end = "Factory";
				break;
			case "DistributionCenter" :
				System.out.println("Your container is going to the Factory!");
				end = "Factory";
				break;
			
			case "Factory":
				System.out.println("Where do you want your item to go?");
				System.out.println("press");
				end = "Factory";
				System.out.println("Press -1- for Warehouse\nPress -2- for Distribution Center");
				userInput2= scanner.nextInt();
				while((userInput2!=1)&(userInput2!=2)) {
					System.out.println("Press -1- for Warehouse\nPress -2- for Distribution Center");
					userInput2= scanner.nextInt(); }
					switch(userInput2) {
					case 1:
						System.out.println("Your is going to the Warehouse!");
						end = "Warehouse";
						break;
					case 2:
						System.out.println("Your is going to the Distribution Center!");
						end = "DistributionCenter";
						break;
					}
					break;
		}
			System.out.println("Which item do you want to transfer?");
			System.out.println("|| Milk -1- || Cream -2- || Cacao -3- ||\n Yeast -4- || Boxed Milk -5- || Chocolate -6- || Yogurt -7- ||");
			userInput3= scanner.nextInt();
			while((userInput3!=1)&(userInput3!=2)&(userInput3!=3)&(userInput3!=4)&(userInput3!=5)&(userInput3!=6)&(userInput3!=7)) {
				System.out.println("|| Milk -1- || Cream -2- || Cacao -3- ||\n Yeast -4- || Boxed Milk -5- || Chocolate -6- || Yogurt -7- ||");
				userInput3= scanner.nextInt();
			}
			
			switch(userInput3)
			{
			case 1: 
				itemToBeTransfered = "Milk";
				break;
			case 2:
				itemToBeTransfered = "Cream";
				break;
			case 3:
				itemToBeTransfered = "Cacao";
				break;
			case 4:
				itemToBeTransfered = "Yeast";
				break;
			case 5:
				itemToBeTransfered = "BoxedMilk";
				break;
			case 6:
				itemToBeTransfered = "Chocolate";
				break;
			case 7:
				itemToBeTransfered = "Yogurt";
				break;
				
				
			}
			System.out.println("Which container do you want to choose?");
			System.out.println("Press -1- for Dry Storage Container\nPress -2- for Open Top Container\nPress -3- for Tank Container");
			int userInput4 = scanner.nextInt();
			while((userInput4!=1)&(userInput4!=2)&(userInput4!=3)) {
				System.out.println("Press -1- for Dry Storage Container\nPress -2- for Open Top Container\nPress -3- for Tank Container");
				userInput4= scanner.nextInt();
			}
			
			switch(userInput4) {
			case 1:
				container = "DryStorageContainer" ;
				break;
			case 2:
				container = "OpenTopContainer";
				break;
			case 3:
				container = "TankContainer";
				break;
				
			}
			Controller.transferTo(itemToBeTransfered,start,end,container);
			
		
		}
		catch(ItemNotCountableException e) {
			System.err.println("ItemNotCountableException");
			System.out.println("There is an error at your given inputs!\nPlease start over!");
		}
		catch(ItemNotUncountableException e) {
			System.err.println("ItemNotUncountableException");
			System.out.println("There is an error at your given inputs!\nPlease start over!");
		}
		catch(DifferentUncountableItemsException e) {
			System.err.println("DifferentUncountableItemsException");
			System.out.println("There is an error at your given inputs!\nPlease start over!");
		}
		break;
	case 2:
		System.out.println("Which ingredient do you want to buy?");
		System.out.println("|| Milk -1- || Cream -2- || Cacao -3- || Yeast -4 ||");
		userInput3= scanner.nextInt();
		while((userInput3!=1)&(userInput3!=2)&(userInput3!=3)&(userInput3!=4)) {
			System.out.println("|| Milk -1- || Cream -2- || Cacao -3- || Yeast -4- ||");
			userInput3= scanner.nextInt();
		
	}
		;
		switch(userInput3) {
		case 1:
			whichIngredient = "Milk";
			break;
		case 2:
			whichIngredient = "Cream";
			break;
		case 3:
			whichIngredient = "Cacao";
			break;
		case 4:
			whichIngredient = "Yeast";
			break;
			
		}
		System.out.println("How many " + whichIngredient + " do you want to buy");
		userInput3= scanner.nextInt();
		while( userInput3 <= 0) {
			System.out.println("How many " + whichIngredient + " do you want to buy");
			userInput3= scanner.nextInt();
		}
		
		int amount = userInput3;
		Controller.buyIngredients(amount,whichIngredient);
		break;
	case 3:
		System.out.println("Which product do you want to sell?");
		System.out.println("|| Boxed Milk -1- || Chocolate -2- || Yogurt -3- ||");
		userInput3= scanner.nextInt();
		while((userInput3!=1)&(userInput3!=2)&(userInput3!=3)) {
			System.out.println("|| Boxed Milk -1- || Chocolate -2- || Yogurt -3- ||");
			userInput3= scanner.nextInt();
	}
		
		switch(userInput3) {
		case 1:
			whichProduct = "BoxedMilk";
			break;
		case 2:
			whichProduct = "Chocolate";
			break;
		case 3:
			whichProduct = "Yogurt";
			break;
		
			
		}
		System.out.println("How many" + whichProduct + "do you want to sell");
		userInput3= scanner.nextInt();
		while( userInput3 <= 0) {
			System.out.println("How many" + whichProduct + "do you want to sell");
			userInput3= scanner.nextInt();
		}
		amount = userInput3;
		Controller.sellProducts(amount,whichProduct);
		break;
	case 4:
		System.out.println("Which product do you want to produce?");
		System.out.println("|| Boxed Milk -1- || Chocolate -2- || Yogurt -3- ||");
		userInput3= scanner.nextInt();
		while((userInput3!=1)&(userInput3!=2)&(userInput3!=3)) 
		{
			System.out.println("|| Boxed Milk -1- || Chocolate -2- || Yogurt -3- ||");
			userInput3= scanner.nextInt();
		}
		switch(userInput3) {
		case 1:
			whichProduct = "BoxedMilk";
			break;
		case 2:
			whichProduct = "Chocolate";
			break;
		case 3:
			whichProduct = "Yogurt";
			break;
		}
		
		
		Controller.produceProduct(whichProduct);
		break;
	
	}
	Controller.printEverything();

	
	
}
scanner.close();
}
}

