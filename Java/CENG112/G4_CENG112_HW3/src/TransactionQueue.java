
public class TransactionQueue {
	private Transaction head;
	private int queueLength;
	private int totalWaitingTime;
	private String date;
	private TransactionQueue next;
	public void insert(Transaction T) 
	{
		if(head==null) 
		{
			this.head=T;
		}
		else if (head.getCustomer().getPriority() > T.getCustomer().getPriority()) {  
	    
	        T.setNext(head);
	        this.head=T;
	    }  
	    else 
	    {  
	    	Transaction temp=head;
	        while (temp.getNext()!=null && temp.getNext().getCustomer().getPriority()<T.getCustomer().getPriority()) 
	        {  
	        	temp=temp.getNext();
	        }  
	        T.setNext(temp.getNext());
	        temp.setNext(T);
	        
	    }  
        this.totalWaitingTime=this.totalWaitingTime+T.getWaiting();
		queueLength++;
	}
	public Transaction remove() 
	{
		Transaction temp=head;
		head=head.getNext();
		queueLength--;
		return temp;
		
	}
	public boolean isEmpty() {
		return queueLength==0;
		
	}
	public boolean clear() 
	{
		if(head==null) 
		return false;
		else {
			this.head=null;
			return true;
		}
		
	}
	public String toString() 
	{
		if(head==null) {
			return " ";
		}
		else {
		Transaction temp=head;
		String string=" ";
		while(temp!=null) 
		{
			string=string+temp.toString();
			temp=temp.getNext();
		}
		return string;
		}
		
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	public TransactionQueue getNext() {
		return next;
	}
	public void setNext(TransactionQueue next) {
		this.next = next;
	}
	

}
