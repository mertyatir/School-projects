package businessApplication;

public class Yogurt implements Countable{
	
	private static final int amount=2;

	public Yogurt() {
		// TODO Auto-generated constructor stub
	}

	public int getAmount() {
		return amount;
	}
	
	public String toString() 
	{
		return amount+"L Yogurt";
	}
}
