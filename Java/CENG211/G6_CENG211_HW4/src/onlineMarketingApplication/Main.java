package onlineMarketingApplication;
import java.io.IOException;
import java.util.*;

public class Main 
{


	
	public static void main(String[] args) throws IOException 
	{
	
		Control control= new Control();
		Scanner keyboard= new Scanner(System.in);
		control.printListOfOperations();
		int choice=keyboard.nextInt();
		while(choice!=0) 
		{
			
			

			switch (choice) {
			case 1:
					control.customerAddsProductsToBasket();
				
				break;
			case 2:
				 control.customerRemovesProductsFromBasket();
				break;
			case 3:
					control.customerBuysTheProductsInTheBasket();
		break;
			case 4:
					control.customerReturnsTheProductsToSupplier();
		break;
			case 5:
				control.regularUserAddsNewAddress();

		break;
			case 6:
				control.selectDeliveryAdress();
		
		break;
			case 7:
				control.depositMoney();
			
		break;

	
				
				
			}
			
			
			control.printListOfOperations();
			
			System.out.println("Please enter a number to choose");
			choice=keyboard.nextInt();

			
			
			
		}
		
		
		keyboard.close();
		
		
		
		

	}

}
