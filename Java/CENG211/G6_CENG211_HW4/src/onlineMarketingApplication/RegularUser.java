
package onlineMarketingApplication;

import java.util.*;

public abstract class RegularUser extends User {
	
	private ContactInfo contactInfo;

//These addresses should be found by their title in order to allow a customer to select his/her delivery address


	
	public RegularUser(String userName, String password,double activeBalance,String telephone,String mail,List<Address> addresses)
	{
		super(userName, password, activeBalance);
		ContactInfo contactInfo= new ContactInfo(telephone, mail, addresses);
		this.contactInfo=contactInfo;
	}
	
	
	public Address findAddress(String givenAddress) 
	{
		return this.contactInfo.findAddress(givenAddress);
	}


	public boolean selectDeliveryAddress(String givenAddress) {
		return contactInfo.selectDeliveryAddress(givenAddress);
	}
	
	
	
	

	




}
