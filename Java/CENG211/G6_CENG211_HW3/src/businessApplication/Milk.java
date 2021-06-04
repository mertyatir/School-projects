package businessApplication;

public class Milk implements Uncountable
{
	private int amount=0;
	public Milk() {
		
	}
	public int getAmount() 
	{
		return amount;
	}
	public void setAmount(int amount) 
	{
	this.amount=amount;
	}
	
	
	public String toString() 
	{
		return amount+"L Milk";
	}

}
