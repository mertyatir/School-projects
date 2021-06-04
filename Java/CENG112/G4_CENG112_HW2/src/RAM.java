
public class RAM implements IProduct
{
	Integer idnumber=null;
	String location=null;
	static String name="RAM";
	
	public RAM(Integer idnumbergeneretor) 
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

	public String getname() {

		return name;
	}
	
}
