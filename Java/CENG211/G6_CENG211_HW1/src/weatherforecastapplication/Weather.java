package weatherforecastapplication;

public class Weather {
	private int wind ; //[0, 75] km/h
	private int temperature; // Celcius [-50, 50] °C
	private int feelsLikeTemperature; // Celcius [-50, 50] °C
	private int humidity; // Percent [0, 100]%
	private int precipitation ; // Percent [0, 100]%
	private String visibility; //{low, medium, high}
	public int getWind() {
		return wind;
	}
	
	
	
	@Override
	public String toString() {
		return "wind=" + wind + ", temperature=" + temperature + ", feelsLikeTemperature="
				+ feelsLikeTemperature + ", humidity=" + humidity + ", precipitation=" + precipitation + ", "
				+ (visibility != null ? "visibility=" + visibility : "") ;
	}



	public void setWind(int wind) {
		this.wind = wind;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getFeelsLikeTemperature() {
		return feelsLikeTemperature;
	}
	public void setFeelsLikeTemperature(int feelsLikeTemperature) {
		this.feelsLikeTemperature = feelsLikeTemperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(int precipitation) {
		this.precipitation = precipitation;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	
}
