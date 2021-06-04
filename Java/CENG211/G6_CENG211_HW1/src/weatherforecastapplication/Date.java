package weatherforecastapplication;

public class Date 
{
	private int day;
	private int month;
	private int year;
	
	public Date() 
	{
		day=0;
		month=0;
		year=0;
	}
	
	public Date(String date) 
	{
		
    	String[] splitted = date.split("\\.");
		day=Integer.valueOf(splitted[0]);
		month=Integer.valueOf(splitted[1]);
		year=Integer.valueOf(splitted[2]);
	}
	
	public int compareTo(Date other) 
	{
		int comparison = 0;
		 if(this.year==other.year) 
		{
			if(this.month==other.month) 
			{
				if(this.day==other.day) 
				{
					comparison=0;
				}
				else if(this.day<other.day) 
				{
					comparison=-1;
				}
				else if(this.day>other.day) 
					comparison=1;
			}
			else if(this.month<other.month) 
			{
				comparison=-1;
			}
			else if(this.month>other.month) 
			{
				comparison=1;
			}

		}
		 else if(this.year<other.year) 
		 {
			 comparison=-1;
		 }
		 else if(this.year>other.year)
		 {
			 comparison=1;
		 }

		return comparison;
	}
	
	public boolean equals(Date other) 
	{
		return compareTo(other)==0;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
