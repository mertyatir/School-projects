package onlineMarketingApplication;

public class Address {
	
	private String addressTitle;
	private String country;
	private String city;
	private String district;
	private String street;
	private String doorNumber;
	
	//immutable

	public Address() 
	{
		this.addressTitle=null;
		this.country = null;
		this.city = null;
		this.district = null;
		this.street = null;
		this.doorNumber = null;
	}
	
	public Address(Address other) // copy constructor
	{
		this.addressTitle=other.getAddressTitle();
		this.country = other.getCountry();
		this.city = other.getCity();
		this.district = other.getDistrict();
		this.street = other.getStreet();
		this.doorNumber = other.getDoorNumber();
	}
	
	public Address(String addressTitle, String country, String city, String district, String street, String doorNumber) {
		super();
		this.addressTitle = addressTitle;
		this.country = country;
		this.city = city;
		this.district = district;
		this.street = street;
		this.doorNumber = doorNumber;
	}





	public String getAddressTitle() {
		return addressTitle;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getStreet() {
		return street;
	}

	public String getDoorNumber() {
		return doorNumber;
	}
	
	

}
