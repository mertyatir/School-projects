package weatherforecastapplication;

public class Region {
	
	private int id; //[1, 7]
	private String name; //{Doğu Anadolu, Ege, …, Marmara}
	private City[] cities; //City[]
	
	
	public Region() 
	{
		id=-1;
		name=null;
		cities=null;
	}
	
	public String toString() 
	{
		return String.valueOf(id)+" "+name; // cities yok, gerekirse eklenecek
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City[] getCities() {
		return cities;
	}
	public void setCities(City[] cities) {
		this.cities = cities;
	}
	
	
}
