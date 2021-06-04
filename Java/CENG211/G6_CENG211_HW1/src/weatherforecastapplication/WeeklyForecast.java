package weatherforecastapplication;


public class WeeklyForecast 
{
	private CityWeather[][] weeklyForecast;
	
	
	public WeeklyForecast(int numberOfCities,int numberOfDays) 
	{
		weeklyForecast= new CityWeather[numberOfCities][numberOfDays];
	}


	public CityWeather[][] getWeeklyForecast() {
		return weeklyForecast;
	}

	public void printTheArray() {
		
				for (CityWeather[] row : weeklyForecast)
		{
			if (row != null)
				for (CityWeather col : row)
					System.out.print(col + " ");

			System.out.println();
		}
	}


	public void setWeeklyForecast(CityWeather[][] weeklyForecast) {
		this.weeklyForecast = weeklyForecast;
	}

	
}
