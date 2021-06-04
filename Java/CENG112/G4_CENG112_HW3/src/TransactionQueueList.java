
public class TransactionQueueList 
{
	private TransactionQueue head;
	private int listLength;
	public TransactionQueue getTQ(String date) 
	{
		if(isEmpty())
			return null;
		else 
		{
		TransactionQueue temp=head;
		while(temp!=null) 
		{
			if(temp.getDate().equals(date))
				return temp;
			temp=temp.getNext();
		} 
		return null;
		}
	
	}
	
	public boolean updateTQ(String date, TransactionQueue TQ) 
	{
		if(isEmpty())
			return false;
		else 
		{
		TransactionQueue temp=head;
		while(temp!=null) 
		{
			if(temp.equals(TQ)) 
			{
				temp.setDate(date);
				return true;
			}
			temp=temp.getNext();
		} 
		return false;
		}

		
	}
	public void insertTo(TransactionQueue TQ) 
	{		
		if(head==null) 
		{
			head=TQ;
			listLength++;
		}

		else {
		TransactionQueue temp=head;
		while(temp.getNext()!=null) 
		{
			temp=temp.getNext();
		}
		temp.setNext(TQ);
		listLength++;
		}
	}
	public TransactionQueue removeTQ(String date) 
	{
		TransactionQueue temp=head;
		while(temp!=null) {
			if(temp.getNext().getDate().equals(date)) {
				TransactionQueue foundit=temp.getNext();
				temp.setNext(foundit.getNext());
				listLength--;
				return foundit;
			}
				
			temp=temp.getNext();
		}
		return null;
		
	}
	public boolean isEmpty() {
		return listLength==0;
		
	}
	public boolean clear() 
	{
		if(isEmpty())
		{
			return false;
		}
		else {
	
		this.head=null;
		return true;
		}
	}
	public String toString() 
	{
		String string=" ";
		TransactionQueue temp=head;
		while(temp!=null)
		{
			string=string+temp.toString();
			temp=temp.getNext();
		}
		return string;
		
	}
}
