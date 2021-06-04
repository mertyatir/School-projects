package businessApplication;

public class Chocolate implements Countable{
	
	private static final double amount=0.5;

	public Chocolate() {
		// TODO Auto-generated constructor stub
	}

	public double getAmount() {
		return amount;
	}
	
	public String toString() 
	{
		return amount+"L Chocolate";
	}

}
