package businessApplication;

public class Cream implements Uncountable
{
	private int amount;
	public Cream() 
	{
		this.amount=0;
	}
	
	public int getAmount() {
	
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount=amount;
		
	}
	
	public String toString() 
	{
		return amount+"L Cream";
	}

}
