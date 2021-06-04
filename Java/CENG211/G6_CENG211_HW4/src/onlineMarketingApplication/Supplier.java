package onlineMarketingApplication;

import java.util.List;

public class Supplier extends RegularUser{
	
	private String shopTitle;
	private long taxNumber;
	private String shopCategory;
	private Shop shop;


	private ProductInventory<Product> soldProducts; 
	//the sold products should be added 
	//to the supplier’s old products inventory 
	//in order to calculate endorsement.
	
	
	
	

	public Supplier(String userName, String password, double activeBalance, String telephone, String mail,
			 String shopTitle, long taxNumber, String shopCategory,List<Address> addresses) 
	{
		super(userName, password, activeBalance, telephone, mail, addresses);
		this.taxNumber=taxNumber;
		this.setShopCategory(shopCategory);
		this.shop=new Shop();
		this.shopTitle=shopTitle;
		this.soldProducts=new ProductInventory<Product>();
	}




	public String getShopTitle() {
		return shopTitle;
	}
	
	public double sellProductAndReturnTaxForAdmin(Product product,int quantity,double totalCost) 
	{
		
		
		double taxForAdmin= totalCost*0.02;
		this.shop.removeElementFromShop(product, quantity);
		this.soldProducts.addElementToInventory(product, quantity);
		this.addActiveBalance(totalCost);

		return taxForAdmin;
	}
	
	public double acceptReturningProduct(Product product,int quantity) 
	{
		double returnedProductPrice=product.getPrice()*quantity;
		this.soldProducts.removeElementFromInventory(product, quantity);
		return returnedProductPrice;
		
	}


	public void clear() {
		soldProducts.clear();
	}


	public boolean contains(Product product) {
		return soldProducts.contains(product);
	}




	public Shop getShop() {
		return shop;
	}




	public void setShop(Shop shop) {
		this.shop = shop;
	}




	public String getShopCategory() {
		return shopCategory;
	}




	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}
	
	
	





}
