
package onlineMarketingApplication;


public abstract class User 
{
	private String userName; //required for a user in order to sign in.
	private String password; //required for a user in order to sign in.
	private double activeBalance; // is zero when a user is first created in the system
	
	
	//Users can deposit money to raise their active balance.
	
									
	
	public User(String userName, String password) 
	{
		
		this(userName,password,0);
	}


	public User(String userName, String password,double activeBalance) {
		super();
		this.userName = userName;
		this.password = password;
		this.activeBalance=activeBalance;
	}



	public String getUsername() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public double getActiveBalance() {
		return activeBalance;
	}
	
	


	public void addActiveBalance(double money) 
	{
		this.activeBalance=this.activeBalance+money;
	}
	
	public void removeActiveBalance(double money) 
	{
		this.activeBalance=this.activeBalance-money;
	}
	
	
	
	
	
	

}
