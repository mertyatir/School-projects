package artVaultApplication;

public class Artist extends Person 
{
	private String[] periods;

	public String[] getPeriods() {
		return periods;
	}

	public void setPeriods(String[] periods) {
		this.periods = periods;
	}

	public int compareTo(Object obj, String whatToCompareBy) 
	{
		Artist artist=(Artist)obj;
		if(whatToCompareBy.equals("name")) 
		{
			return this.getName().compareTo(artist.getName());
		}
		else if(whatToCompareBy.equals("birthday")) 
		{
			return this.getBorn()-artist.getBorn();
		}
		else if(whatToCompareBy.equals("nationality"))
		{
			return this.getNationality().compareTo(artist.getNationality());
		}
		
	else 
	{
		return 0;
	}
	}
	public String toString()
	{
		String temp="";
		for (String string : periods) 
		{
			temp=temp+" "+ string;
		}
		return "Name: " +this.getName()+" Born: "+String.valueOf(this.getBorn())+" Died: "+String.valueOf((this.getDied()))
		+" Nationality: "+this.getNationality()+" Periods that he/she lived: "+temp+"\n";
	}

	
	public boolean search(String whattosearchfor) 
	{
		for (String string : periods) 
		{
			if(string.equalsIgnoreCase(whattosearchfor))
				return true;
		}

		return String.valueOf(this.getBorn()).equalsIgnoreCase(whattosearchfor)
				||String.valueOf(this.getDied()).equalsIgnoreCase(whattosearchfor)
				||this.getName().equalsIgnoreCase(whattosearchfor)
				||this.getNationality().equalsIgnoreCase(whattosearchfor)
				;
	}
	

	

	
	
}
