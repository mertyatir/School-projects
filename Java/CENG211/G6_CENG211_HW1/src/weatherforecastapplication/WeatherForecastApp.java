package weatherforecastapplication;

import java.io.IOException;

public class WeatherForecastApp {

	public static void main(String[] args) throws IOException
	{
		
		WeeklyForecast weeklyForecast=FileIO.readFiles(); 
		// warning: first index of weeklyForecast(CityWeather[][]) starts from 1 not 0
		
		//use getWeeklyForecast() method for reaching it
		
		//weeklyForecast.printTheArray(); 
		
		
		
		WeatherQuery.query(weeklyForecast);
		
	}

}
