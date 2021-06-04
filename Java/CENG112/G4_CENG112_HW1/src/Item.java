
public class Item 
{ 
	
	private String name;
	private String disposableType;
	private int amount;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisposableType() {
		return disposableType;
	}
	public void setDisposableType(String disposableType) {
		this.disposableType = disposableType;
	}
	public int getAmount() {
		return this.amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
	String amount_to_String = Integer.toString(amount);
	
	return name + " " + disposableType + " " + amount_to_String;}
	
    public boolean equals(Item item) {
    	if (item==null) return false;
    	if (getClass() != item.getClass()) return false;
    	
    	boolean samename=false;
    	boolean samedisposabletype=false;
    	boolean sameamount=false;
    	
    	if (this.amount== item.amount)
    		sameamount=true;
    	if (this.disposableType.equalsIgnoreCase(item.disposableType))
    		samedisposabletype=true;
    	if (this.name.equalsIgnoreCase(item.name))
    		samename= true;
    	return sameamount && samedisposabletype && samename;
    		
			
		}
    		  	
    }
	



