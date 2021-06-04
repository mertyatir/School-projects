
public class Cache implements IProduct
{

	Integer idnumber=null;
	String location=null;
	static String name="Cache";
	
	public Cache(Integer idnumbergeneretor) 
	{
		this.idnumber=idnumbergeneretor;
	}

	public boolean isManufactured() {
		return location=="FactoryLine";
	}

	public boolean isStored() {
		return location=="GraphicsCardWarehouse";
	}

	public boolean isSold() {
		return location=="Consumer";
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String getname() {
		return name;
	}
	
}


