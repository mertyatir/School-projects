package weatherforecastapplication;

public class CityWeather {
	
	private City city;
	private Weather weather;
	private Date date; // {14.10.2019, 15.10.2019, …, 20.10.2019}
	
	public CityWeather() 
	{
		city=null;
		weather=null;
		date=null;
		
	}
	
	public String toString()
	{
		return city.toString();
		
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
