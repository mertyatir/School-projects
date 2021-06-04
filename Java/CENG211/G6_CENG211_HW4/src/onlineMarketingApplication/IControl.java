package onlineMarketingApplication;

public interface IControl 
{
	
	public void customerAddsProductsToBasket();
	public void customerRemovesProductsFromBasket();  
	public void customerBuysTheProductsInTheBasket(); 
	public void customerReturnsTheProductsToSupplier(); 
	public void regularUserAddsNewAddress();
	public void selectDeliveryAdress();
	public void depositMoney();
}
