package onlineMarketingApplication;

public interface IInventory<T> {
	public void addElementToInventory(T product ,int quantity);
	public boolean removeElementFromInventory(T product, int quantity);
	
}
