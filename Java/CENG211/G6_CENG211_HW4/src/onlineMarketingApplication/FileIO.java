package onlineMarketingApplication;

import java.io.*;
import java.util.*;

public class FileIO {
	
	private static final String usersFile = "users.csv";
	private static final String productsFile = "products.csv";
	
	
	// read and write

	
	public static List<User> readUserFile() throws IOException {
		
		BufferedReader br  = new BufferedReader(new FileReader(usersFile));
		String currentLine;
		
		User user=null;
		
		List<User> userList= new ArrayList<User>();
		
		currentLine = br.readLine();
		
		while ((currentLine = br.readLine()) != null) 
		{
        	String[] splitted = currentLine.split(",");
        	
        	int userType= Integer.valueOf(splitted[0]);
        	//The user type 1 is the admin, type 2 is a customer and type 3 is a supplier.
        	
        	
        	
        	//For 1 2 and 3
        	String userName=splitted[1];
        	String password=splitted[2];
        	double activeBalance= Double.valueOf(splitted[3]);
        	
        	//For 2 and 3
        	
        	String telephone=null;
        	String email=null;
        	
        	
        	//For 3
        	
        	String shopCategory=null;
        	String shopTitle=null;
        	long taxNumber=0;
        	
        	
        	//For 2 and 3
        	String addressTitle=null;
        	String country=null;
        	String city=null;
        	String district=null;
        	String street=null;
        	String doorNumber=null;
        	
        	
        	
        	
        	if(userType==2 || userType==3) 
        	{
        	telephone=splitted[4];
        	email=splitted[5];
        	}
        	
        	if(userType==3) 
        	{
        
        	shopCategory=splitted[6];
        	shopTitle=splitted[7];
        	taxNumber=Long.valueOf(splitted[8].substring(2));
        	}
        	
        	int i=9;
        	
        	boolean thereIsMoreAdress=true;
        	
        	
        	Address address=null;
        	
        	
        	List<Address> addresses= new ArrayList<Address>();
        	
        	while(thereIsMoreAdress) 
        	{
        	try 
        	{
        		addressTitle=splitted[i];
        		i++;
            	country=splitted[i];
            	i++;
            	city=splitted[i];
            	i++;
            	district=splitted[i];
            	i++;
            	street=splitted[i];
            	i++;
            	doorNumber=splitted[i];
            	i++;
            	address= new Address(addressTitle, country, city, district, street, doorNumber);
            	addresses.add(address);
        		
			} 
        	catch (ArrayIndexOutOfBoundsException e) 
        	{
        		thereIsMoreAdress=false;
			}
        	}
        	

        	switch (userType) {
			case 1:		//admin 
				
				user= new AdminUser(userName, password, activeBalance);
				break;
			case 2: 	//customer
				
				user= new Customer(userName, password, activeBalance, telephone, email, addresses);
				break;
			case 3:	//supplier
				user= new Supplier(userName, password, activeBalance, telephone, email, shopTitle, taxNumber, shopCategory, addresses);
				break;

			default:
				break;
			}
        	
        	userList.add(user);
        	
        	}
        	
        	br.close();
			return userList;
		}
	
	



	
	public static List<ProductInventory<Product>> readProductFile() throws IOException 
	{
		
		
		BufferedReader br  = new BufferedReader(new FileReader(productsFile));
		String currentLine;
		ProductInventory<Product> houseWareInventory= new ProductInventory<Product>();
		ProductInventory<Product> electronicInventory= new ProductInventory<Product>();
		ProductInventory<Product> accessoryInventory= new ProductInventory<Product>();
		ProductInventory<Product> cosmeticInventory= new ProductInventory<Product>();
		
		List<ProductInventory<Product>> listOfInventories= new ArrayList<ProductInventory<Product>>();
		
		currentLine = br.readLine();
		
		while ((currentLine = br.readLine()) != null) 
		{
        	String[] splitted = currentLine.split(",");
        	
        	//There is {product category, product name, price, weight, quantity}
        	//information at each line of this file.
        	
        	String category=splitted[0];
        	String name=splitted[1];
        	double price=Double.valueOf(splitted[2]);
        	double weight=Double.valueOf(splitted[3]);
        	int quantity=Integer.valueOf(splitted[4]);
        	
        	Product product=null;
        	
        	
        	
        	if(category.equalsIgnoreCase("houseware")) 
        	{
        		product=new Product(category, name, price, weight);
        		houseWareInventory.addElementToInventory(product, quantity);
        		
        		
        	}
        	
        	else if(category.equalsIgnoreCase("electronic")) 
        	{
        		product=new Product(category, name, price, weight);
        		electronicInventory.addElementToInventory(product, quantity);
        		
        		
        	}
        	else if(category.equalsIgnoreCase("accessories"))
        	{
        		product= new Product(category, name, price, weight, 4.5);
        		accessoryInventory.addElementToInventory(product, quantity);
        		
        	}
        	else if(category.equalsIgnoreCase("cosmetic"))
        	{
        		product= new Product(category, name, price, weight, 3.5);
        		cosmeticInventory.addElementToInventory(product, quantity);
        		
        	}
        	else 
        	{
        		System.out.println("Undefined category!");
        	}
        	

        
		}
		
    	listOfInventories.add(houseWareInventory);
    	listOfInventories.add(electronicInventory);
    	listOfInventories.add(accessoryInventory);
    	listOfInventories.add(cosmeticInventory);
        	
		br.close();
		return listOfInventories;
	}
	
	
	

}
