package businessApplication;

public class BoxedMilk implements Countable{
	
	private static final int amount=1;
	public int getAmount() {
		return amount;
	}
	
	public String toString() 
	{
		return amount+"L Boxed Milk";
	}
}
