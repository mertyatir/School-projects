
public class Transaction {
	
	private int id; // unique id in [1,1000]
	private ICustomer customer; // the request owner
	private int occupation; // needed time for transaction
	private int waiting; // needed time for previous transactions
	private Transaction next;
	
	public String toString() 
	{
		return String.valueOf(id)+" "+customer.toString()+" "+String.valueOf(occupation)+" "+String.valueOf(waiting);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ICustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}

	public int getOccupation() {
		return occupation;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	public int getWaiting() {
		return waiting;
	}

	public void setWaiting(int waiting) {
		this.waiting = waiting;
	}

	public Transaction getNext() {
		return next;
	}

	public void setNext(Transaction next) {
		this.next = next;
	}
	
	// Constructors, getter setter and other helper methods

}
