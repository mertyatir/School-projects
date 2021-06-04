package artVaultApplication;
import java.io.*;
import java.util.*;


public class CSVReader 
{
	private static final String artVaultDate = "CENG211_HW2_ArtVaultData.csv";
	
	
	public static Vault readFile() throws IOException
	{
		
		String sCurrentLine;
		BufferedReader br  = new BufferedReader(new FileReader(artVaultDate));  
		Vault vault= new Vault();
		
    	List<Person> famouspeople = new ArrayList<Person>();
    	List<Artwork> artworks = new ArrayList<Artwork>();
  

    while ((sCurrentLine = br.readLine()) != null) 
	{
    	String[] splitted = sCurrentLine.split(",");
    	
    	if(splitted[0].equals("1")) 
    	{
    		Painting painting=new Painting();
    		painting.setName(splitted[1]);
    		painting.setStyle(splitted[2]);
    		painting.setArtist(splitted[3]);
    		painting.setDimension1(Float.valueOf(splitted[4]));
    		painting.setDimension2(Float.valueOf(splitted[5]));
    		
    		artworks.add(painting);
    	}
    	else if(splitted[0].equals("2")) 
    	{
    		Sculpture sculpture= new Sculpture();
    		sculpture.setName(splitted[1]);
    		sculpture.setStyle(splitted[2]);
    		sculpture.setArtist(splitted[3]);
    		sculpture.setMaterial(splitted[4]);
    		sculpture.setWeight(Integer.valueOf(splitted[5]));
    		
    		artworks.add(sculpture);
    	}
    	else if(splitted[0].equals("3"))
    	{
    		Architecture architecture= new Architecture();
    		architecture.setName(splitted[1]);
    		architecture.setStyle(splitted[2]);
    		architecture.setDimension1(Float.valueOf(splitted[3]));
    		architecture.setDimension2(Float.valueOf(splitted[4]));
    		architecture.setDimension3(Float.valueOf(splitted[5]));
    		
    		int index=0;
    		int numberOfArchitectsLeft=(splitted.length)-6;
    		String[] architects= new String[numberOfArchitectsLeft];
    		
    		while(numberOfArchitectsLeft!=0) 
    		{
    		architects[index]=splitted[6+index];
    		numberOfArchitectsLeft--;
    		index++;
    		}
    		
    		architecture.setArchitects(architects);
    		
    		
    		artworks.add(architecture);
    		
    	}
    	else if(splitted[0].equals("4"))
    	{
    		Artist artist= new Artist();
    		artist.setName(splitted[1]);
    		artist.setBorn(Integer.valueOf(splitted[2]));
    		artist.setDied(Integer.valueOf(splitted[3]));
    		artist.setNationality(splitted[4]);
    		
    		int numberOfPeriodsLeft=(splitted.length)-5;
    		String[] periods= new String[numberOfPeriodsLeft];
    		int index=0;
  
    		while(numberOfPeriodsLeft!=0) 
    		{
    		periods[index]=splitted[5+index];
    		numberOfPeriodsLeft--;
    		index++;
    		}
    		
    		artist.setPeriods(periods);
    		famouspeople.add(artist);
    	}
    	else if(splitted[0].equals("5"))
    	{
    		Architect architect=new Architect();
    		architect.setName(splitted[1]);
    		architect.setBorn(Integer.valueOf(splitted[2]));
    		architect.setDied(Integer.valueOf(splitted[3]));
    		architect.setNationality(splitted[4]);
    		famouspeople.add(architect);
    	}
    	
    		
	}
    br.close();
    
    	vault.setFamouspeople(famouspeople);
    	vault.setArtworks(artworks);
		return vault;
	}
	
}
