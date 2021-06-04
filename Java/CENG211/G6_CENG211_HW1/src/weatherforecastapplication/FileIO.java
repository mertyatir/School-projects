package weatherforecastapplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO 
{

	private static final String citiesFile = "CENG211_HW1_Cities.csv";
	//PlateNo,Name,RegionID,RegionName,Altitude
	private static final String weeklyForecastFile = "CENG211_HW1_WeeklyForecast.csv"; 
	//PlateNo,Date,Wind,Temperature,FeelsLikeTemperature,Humidity,Precipitation,Visibility

	
	public static WeeklyForecast readFiles() throws IOException
	{
		
		String sCurrentLine;
		WeeklyForecast weeklyForecast;
	
	

		BufferedReader br  = new BufferedReader(new FileReader(citiesFile));  
        
        int numberOfCities=0;
        int numberOfDays=0;
        
        while ((sCurrentLine = br.readLine()) != null) 
		{
        	String[] splitted = sCurrentLine.split(",");
        	
        	int plateNo= Integer.valueOf(splitted[0]);
        	
        	if (plateNo>0) 
        	{
        		numberOfCities++;  //counting the number of cities before creating an array for them
        	}
        	
        	
		}
        br.close();	      
        
        br  = new BufferedReader(new FileReader(weeklyForecastFile)); 
        
        
        while ((sCurrentLine = br.readLine()) != null) 
		{
        	String[] splitted = sCurrentLine.split(",");
        	
        	int plateNo=Integer.valueOf(splitted[0]);
        	
        	if(plateNo==1) 
        	{
        		numberOfDays++;  //counting the number of days before creating an array for them
        	}
        	else
        		break;
        	
     
   
        	
		}
        
        weeklyForecast= new WeeklyForecast(numberOfCities+1, numberOfDays);  // this method will return this object after filling it
        
        br.close();
        
        
        br  = new BufferedReader(new FileReader(citiesFile));
        
        
        City[] cities=new City[numberOfCities+1];
    
		while ((sCurrentLine = br.readLine()) != null) 
		{
			
		
			
			String[] splitted = sCurrentLine.split(",");
		
			int plateNo= Integer.valueOf(splitted[0]);
			String name=splitted[1];
			int regionId=Integer.valueOf(splitted[2]);
			String regionName=splitted[3];
			int altitude=Integer.valueOf(splitted[4]);	
		
		
			Region region= new Region();
		
			region.setId(regionId);
			region.setName(regionName);
		
			City city=new City();
			city.setPlateNo(plateNo);
			city.setName(name);
			city.setRegion(region); 
			city.setAltitude(altitude);
			
		
			cities[plateNo]=city;
			
			//System.out.println(city.toString());
			

		

		}
	br.close();
	
    br  = new BufferedReader(new FileReader(weeklyForecastFile));
    CityWeather[] cityWeathers=null;
	int size=0;
    
    while ((sCurrentLine = br.readLine()) != null) 
	{
    	String[] splitted = sCurrentLine.split(",");
    	
    	int plateNo= Integer.valueOf(splitted[0]);
    	Date date= new Date(splitted[1]); 
    	int wind=Integer.valueOf(splitted[2]);
    	int temperature=Integer.valueOf(splitted[3]);
    	int feelsLikeTemperature=Integer.valueOf(splitted[4]);
    	int humidity=Integer.valueOf(splitted[5]);
    	int precipitation=Integer.valueOf(splitted[6]);
    	String visibility=splitted[7];
    	
    	
    	
    	
    	Weather weather= new Weather();
    	weather.setWind(wind);
    	weather.setTemperature(temperature);
    	weather.setFeelsLikeTemperature(feelsLikeTemperature);
    	weather.setHumidity(humidity);
    	weather.setPrecipitation(precipitation);
    	weather.setVisibility(visibility);
    	
    	
    	CityWeather cityWeather=new CityWeather();
    	cityWeather.setCity(cities[plateNo]);
    	cityWeather.setWeather(weather);
    	cityWeather.setDate(date);
    	
    	

    	if(cityWeathers==null) 
    	{
    		cityWeathers= new CityWeather[numberOfDays];
    		size=0;
    	}
    	
    	if(cityWeathers.length>size) 
    	{
    		cityWeathers[size]=cityWeather;
    		size++;
    		if(cityWeathers.length==size) 
    		{
    			weeklyForecast.getWeeklyForecast()[plateNo]=cityWeathers;
    			cityWeathers=null;
    		}
    	}

    		
    	//System.out.println(weather.toString());
    	
	}
    br.close();
	
	
	

	
		return weeklyForecast;
	}
	


}
