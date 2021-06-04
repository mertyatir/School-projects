package artVaultApplication;

public class Architect extends Person
{


	public int compareTo(Object obj, String whatToCompareBy) 
	{
		Architect architect=(Architect)obj;
		if(whatToCompareBy.equals("name"))
		{
			return this.getName().compareTo(architect.getName());
		}
		else if(whatToCompareBy.equals("birthday"))
			{
				return this.getBorn()-architect.getBorn();
			}
		
		else if(whatToCompareBy.equals("nationality"))
		{
			return this.getNationality().compareTo(architect.getNationality());
		}
		else 
		{
			return 0;
		}
	

	}
	public String toString() 
	{
		return "Name: "+this.getName()+" Born: "+String.valueOf(this.getBorn())+" Died: "+String.valueOf(this.getDied())+" Nationality: "+this.getNationality()+"\n";
	}
	public boolean search(String whattosearchfor) 
	{
		return String.valueOf(this.getBorn()).equalsIgnoreCase(whattosearchfor)
				|| String.valueOf(this.getDied()).equalsIgnoreCase(whattosearchfor)
				||this.getName().equalsIgnoreCase(whattosearchfor)
				||this.getNationality().equalsIgnoreCase(whattosearchfor)
				;
	}

	
	


		
}
