import java.io.*;

public class BankTransactionManagementSystem {
	private static final String FileName = "CENG112_HW3_Transactions.txt";
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = null;
		FileReader fr = null; 
		fr = new FileReader(FileName);
		br = new BufferedReader(fr);
		String currentline=br.readLine();
		String[] splitted = currentline.split(",");

		String previousdate=" ";
		
		TransactionQueueList transactionqueuelist= new TransactionQueueList();
		TransactionQueue transactionqueue= new TransactionQueue();

		while (currentline!=null) 
		{
			splitted = currentline.split(",");
			String date= splitted[0];
			String transaction_id=splitted[1];
			String customer_type=splitted[2];
			String occupation_time=splitted[3];
			currentline=br.readLine();
			
			
			Customer customer=new Customer(customer_type);
			Transaction transaction= new Transaction();
			transaction.setId(Integer.valueOf(transaction_id));
			transaction.setCustomer(customer);
			transaction.setOccupation(Integer.valueOf(occupation_time));
			
			if ((!(previousdate.equals(date)) && !(previousdate.equals(" "))))
			{
				transactionqueue.setDate(previousdate);
				transactionqueuelist.insertTo(transactionqueue);
				transactionqueue= new TransactionQueue();
			}	
			transactionqueue.insert(transaction);
			previousdate=date;
		}
		transactionqueue.setDate(previousdate);
		transactionqueuelist.insertTo(transactionqueue);
		
		br.close();
		System.out.println(transactionqueuelist.toString());

	}

}
