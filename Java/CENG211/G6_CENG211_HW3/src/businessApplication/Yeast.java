package businessApplication;

public class Yeast implements Uncountable{
	private int amount;
	public Yeast() 
	{
		this.amount=0;
	}
	
	public int getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	public void setAmount(int amount) {
		this.amount=amount;
	}
	
	
	public String toString() 
	{
		return amount+"L Yeast";
	}
	
}
