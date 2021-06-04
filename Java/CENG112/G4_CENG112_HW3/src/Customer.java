
public class Customer implements ICustomer
{
	private int priority;
	private String type;
	
	 Customer(String customer_type)
	 {
		 if (customer_type.equals("CORPORATE")) 
		{
			this.priority=1;
			this.type="CORPORATE";
		}
		 else if (customer_type.equals("INDIVIDUAL")) 
			{
			 this.priority=2;
			 this.type="INDIVIDUAL";
			}
		 else if (customer_type.equals("NON-REGISTERED")) 
			{
			 this.priority=3;
			 this.type="NON-REGISTERED";
			}
	 }
	
	public String getType() {
		return this.type;
	}

	public int getPriority() {
		return this.priority;
	}
	public String toString() 
	{
		return type;
		
	}

}
