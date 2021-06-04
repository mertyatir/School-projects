
public class CPU implements IProduct
{

	Integer idnumber=null;
	String location=null;
	static String name="CPU";
	
	public CPU(Integer idnumbergeneretor) 
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


