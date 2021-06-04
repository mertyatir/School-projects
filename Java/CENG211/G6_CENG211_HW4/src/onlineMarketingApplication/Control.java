package onlineMarketingApplication;
import java.io.IOException;
import java.util.*;

public class Control implements IControl{
	
	
	private User currentUser;
	
	
	List<User> users;
	List<ProductInventory<Product>> products;

	
	private List<Supplier> supplierList;
	private List<Customer> customerList;
	private AdminUser adminUser;
	
	
	
	ProductInventory<Product> houseware;
	ProductInventory<Product> electronic;
	ProductInventory<Product> accessories;
	ProductInventory<Product> cosmetic;
	
	
	
	


	
	
	public Control() throws IOException 
	{
		this.currentUser=null;

		
		this.products=FileIO.readProductFile();
		this.users=FileIO.readUserFile();
		this.houseware= this.products.get(0);
		this.electronic= this.products.get(1);
		this.accessories= this.products.get(2);
		this.cosmetic= this.products.get(3);
		
		
		this.supplierList=new ArrayList<Supplier>();
		this.customerList=new ArrayList<Customer>();
		this.adminUser=null;
		
		for (User user : users) 
		{
			if(user instanceof Supplier) 
			{
				supplierList.add((Supplier) user);
			}
			else if((user instanceof Customer))
					{
				customerList.add((Customer) user);
					}
			else if(user instanceof AdminUser) 
			{
				adminUser=(AdminUser) user;
			}
		}
		
		for (Supplier supplier : supplierList) 
		{
			if(supplier.getShopCategory().equalsIgnoreCase("houseware")) 
			{
				supplier.getShop().setInventory(houseware);
			}
			else if(supplier.getShopCategory().equalsIgnoreCase("electronic")) 
			{
				supplier.getShop().setInventory(electronic);
			}
			else if(supplier.getShopCategory().equalsIgnoreCase("accessories")) 
			{
				supplier.getShop().setInventory(accessories);
			}
			else if(supplier.getShopCategory().equalsIgnoreCase("cosmetic")) 
			{
				supplier.getShop().setInventory(cosmetic);
			}
		}
	
			
	
		
		
		
		
		logIn();
	
	}
	
	
	


	private boolean logIn() 
	{
		@SuppressWarnings("resource")
		Scanner keyboard= new Scanner(System.in);
		
		System.out.println("Enter an username");
		
	
		
		String enteredUserName=keyboard.nextLine();
		
		System.out.println("Enter a password");
		
		String enteredPassword= keyboard.nextLine();
		
		
		
		for (User user : users) 
		{
			if(user.getPassword().equalsIgnoreCase(enteredPassword) & user.getUsername().equalsIgnoreCase(enteredUserName))
			{
				this.currentUser=user;
				return true;
			}

		}
		
		System.out.println("No such user with given Username and Password. Please try again.");
		
		
		return logIn();
		
		
	
		
	}


	
	public void printListOfOperations() 
	{
		System.out.println(
				"0) Exit\n" +
				"1) Add Products To Basket\n" + 
				"2) Remove Products From Basket\n" + 
				"3) Buy Products In The Basket\n" + 
				"4) Return Products To Supplier\n" + 
				"5) Add New Address\n" + 
				"6) Select Delivery Adress\n" + 
				"7) Deposit Money\n" + 
				"	");
	}
	
	
	
	public void customerAddsProductsToBasket()
	{
		if(this.currentUser instanceof Customer) 
		{
			currentUser=(Customer) currentUser;
			Scanner keyboard= new Scanner(System.in);
			System.out.println("Enter product name");
			String productName=keyboard.nextLine();
			
			boolean found=false;
			Product product=null;
			
			for (ProductInventory<Product> productInventory : products) 
			{
				try {
					product=productInventory.findProduct(productName);
					found=true;
				} catch (ProductNotFoundException e) 
				{
					continue;
				}
			}
			
			
			if(found) 
			{
				System.out.println("Enter quantity");
				int quantity=keyboard.nextInt();
				String category=product.getCategory();
				
				int howMuchThereAre=0;
				
	        	if(category.equalsIgnoreCase("houseware")) 
	        	{
	        		howMuchThereAre=this.houseware.inventory.get(product);
	        	}
	        	
	        	else if(category.equalsIgnoreCase("electronic")) 
	        	{
	        		howMuchThereAre=this.electronic.inventory.get(product);
	        	}
	        	else if(category.equalsIgnoreCase("accessories"))
	        	{
	        		howMuchThereAre=this.accessories.inventory.get(product);
	        	}
	        	else if(category.equalsIgnoreCase("cosmetic"))
	        	{
	        		howMuchThereAre=this.cosmetic.inventory.get(product);
	        	}
	        	
	        	if(quantity>howMuchThereAre) 
	        	{
	        		System.out.println("There is less than "+ quantity+ " " +productName+ " There are only "+ howMuchThereAre +" left");
	        		
	        	}
	        	else 
	        	{
	        		((Customer) currentUser).addToBasket(product, quantity);
	        		
	        	}
	
			}
			
			else 
			{
				System.out.println("There is no product named "+ productName );
			}
			
			
		}
		else 
		{
			System.out.println("You need to be a customer to buy things");
			logIn();
		}
		
		
	}



	@Override
	public void customerRemovesProductsFromBasket() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void customerBuysTheProductsInTheBasket() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void customerReturnsTheProductsToSupplier() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void regularUserAddsNewAddress() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void selectDeliveryAdress() {
		// TODO Auto-generated method stub
		
	}




	public void depositMoney() 
	{
	
		
	}



	
	

}
