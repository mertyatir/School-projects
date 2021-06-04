package businessApplication;

public class Cacao implements Uncountable{
	private int amount;
	public Cacao() 
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
		return amount+"L Cacao";
	}

}
