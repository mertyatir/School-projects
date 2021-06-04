
public class GraphicsCard implements IProduct
{
	Integer idnumber=null;
	String location=null;
	static String name="GraphicsCard";
	
	public GraphicsCard(Integer idnumbergeneretor) 
	{
		this.idnumber=idnumbergeneretor;
	}

	public boolean isManufactured() {
		return !(idnumber==null);
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
