package weatherforecastapplication;

public class City 
{
	private int plateNo; //[1, 81]
	private String name; //{Adana, Adıyaman, Afyon, …, Düzce}
	private Region region; //{Doğu Anadolu, Ege, …, Marmara}
	private int altitude; //[0, 5000] m
	
	
	public City() 
	{
		plateNo=-1;
		name=null;
		region=null;
		altitude=-1;
		
	}
	
	public String toString() 
	{
		
		return String.valueOf(plateNo)+" "+name+" "+region.toString()+" "+String.valueOf(altitude);
		
	}
	public int getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(int plateNo) {
		this.plateNo = plateNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	
	
}
