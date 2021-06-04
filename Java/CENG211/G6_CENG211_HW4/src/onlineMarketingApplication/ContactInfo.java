package onlineMarketingApplication;

import java.util.*;

public class ContactInfo {
	
	private String telephone; 
	private String mail; 
	private List<Address> addresses;
	private Address deliveryAdress;

	

	
	public ContactInfo(ContactInfo other) //copy constructor
	{
		super();
		this.telephone=other.getTelephone();
		this.mail =	other.getMail();
		this.addresses =other.getAddresses();
	}
	
	

	public ContactInfo(String telephone, String mail, List<Address> addresses) {
		super();
		this.telephone = telephone;
		this.mail = mail;
		this.addresses = addresses;
	}
	

	public String getTelephone() {
		return telephone;
	}

	public String getMail() {
		return mail;
	}
	
	
	public Address findAddress(String givenAddress) 
	{
		
		for (Address address : addresses) 
		{
			if(address.getAddressTitle().equalsIgnoreCase(givenAddress)) 
			{
				return address;
			}
				
		}
		return null;
	}
	public boolean selectDeliveryAddress(String givenAddress) 
	{
		Address address=this.findAddress(givenAddress);
		
		if(address!=null) 
		{
			this.deliveryAdress=address;
			return true;
		}
		else
		{
			return false;
		}
	}



	public List<Address> getAddresses() 
	{
		
		List<Address> tempList= new ArrayList<Address>();
		
		
		for (Address address : this.addresses)
		{
			tempList.add(address);
		}
		
		return tempList;
	}



	public Address getDeliveryAdress() 
	{
		return new Address(deliveryAdress);
	}
	
	



	

}
