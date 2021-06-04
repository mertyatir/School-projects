package artVaultApplication;

public interface ITradable 
{
	public boolean isTradable();
	public void tradeToBuyer(Buyer buyer,Seller seller);
	
}
