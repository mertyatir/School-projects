package artVaultApplication;

import java.io.IOException;
import java.util.*;

public class ArtVaultAppMenu 
{
	public static void main(String[] args) throws IOException 
	{
		Vault vault=CSVReader.readFile();
		List<Person> people=vault.getFamouspeople();
		List<Artwork> artworks=vault.getArtworks();
		Scanner keyboard= new Scanner(System.in);
		System.out.println("1)Print the lists\n2)Search the vault\n3)Trade\n0)Exit");
		int choice=keyboard.nextInt();
		
		
		while(choice!=0) 
		{
		if(choice==1) 
		{
			
			System.out.println("Please choose the list\n"
					+ "1)Artists\n"
					+ "2)Architects\n"
					+ "3)Paintings\n"
					+ "4)Sculptures\n"
					+ "5)Architectures\n"
					+ "0)Exit");
			int secondchoice=keyboard.nextInt();
			int thirdchoice;
			switch (secondchoice) {
			case 1:
				List<Artist> artists= new ArrayList<Artist>();
				for (Person person : people) 
				{
					if(person instanceof Artist) 
					{
						artists.add((Artist)person);
					}
				}
					System.out.println("Please choose the sorting method\n\n1)Sort by name\n2)Sort by birthday\n3)Sort by nationality\n0)Exit");
					thirdchoice=keyboard.nextInt();
					if(thirdchoice==1) 
					{
						ArrayListSorter.sortArtist(artists, "name");
					}
					if(thirdchoice==2)
					{
						ArrayListSorter.sortArtist(artists, "birthday");
					}
					if(thirdchoice==3) 
					{
						ArrayListSorter.sortArtist(artists, "nationality");
					}
					if(thirdchoice==0) 
					{
						choice=0;
						break;
					}
					System.out.println(artists.toString());
				break;
			case 2:
				List<Architect> architects= new ArrayList<Architect>();
				for (Person person : people) 
				{
					if(person instanceof Architect) 
					{
						architects.add((Architect)person);
					}
				}
					System.out.println("Please choose the sorting method\n\n1)Sort by name\n2)Sort by birthday\n3)Sort by nationality\n0)Exit");
					thirdchoice=keyboard.nextInt();
					if(thirdchoice==1) 
					{
						ArrayListSorter.sortArchitect(architects, "name");
					}
					if(thirdchoice==2)
					{
						ArrayListSorter.sortArchitect(architects, "birthday");
					}
					if(thirdchoice==3) 
					{
						ArrayListSorter.sortArchitect(architects, "nationality");
					}
					if(thirdchoice==0) 
					{
						choice=0;
						break;
					}
					System.out.println(architects.toString());
					
				
				break;
			case 3:
				List<Painting> paintings= new ArrayList<Painting>();
				for (Artwork artwork : artworks) 
				{
					if(artwork instanceof Painting) 
					{
						paintings.add((Painting)artwork);
					}
				}
					System.out.println("Please choose the sorting method\n\n1)Sort by name\n2)Sort by style\n3)Sort by artist\n0)Exit");
					thirdchoice=keyboard.nextInt();
					if(thirdchoice==1) 
					{
						ArrayListSorter.sortPainting(paintings, "name");
					}
					if(thirdchoice==2)
					{
						ArrayListSorter.sortPainting(paintings, "style");
					}
					if(thirdchoice==3) 
					{
						ArrayListSorter.sortPainting(paintings, "artist");
					}
					if(thirdchoice==0) 
					{
						choice=0;
						break;
					}
					System.out.println(paintings.toString());
				break;
			case 4:
				List<Sculpture> sculptures= new ArrayList<Sculpture>();
				for (Artwork artwork : artworks) 
				{
					if(artwork instanceof Sculpture) 
					{
						sculptures.add((Sculpture)artwork);
					}
				}
					System.out.println("Please choose the sorting method\n\n1)Sort by name\n2)Sort by style\n3)Sort by artist\n0)Exit");
					thirdchoice=keyboard.nextInt();
					if(thirdchoice==1) 
					{
						ArrayListSorter.sortSculpture(sculptures, "name");
					}
					if(thirdchoice==2)
					{
						ArrayListSorter.sortSculpture(sculptures, "style");
					}
					if(thirdchoice==3) 
					{
						ArrayListSorter.sortSculpture(sculptures, "artist");
					}
					if(thirdchoice==4) 
					{
						ArrayListSorter.sortSculpture(sculptures, "material");
					}
					if(thirdchoice==0) 
					{
						choice=0;
						break;
					}
					System.out.println(sculptures.toString());
				
				break;
			case 5:
				List<Architecture> architectures= new ArrayList<Architecture>();
				for (Artwork artwork : artworks) 
				{
					if(artwork instanceof Architecture) 
					{
						architectures.add((Architecture)artwork);
					}
				}
					System.out.println("Please choose the sorting method\n\n1)Sort by name\n2)Sort by style\n0)Exit");
					thirdchoice=keyboard.nextInt();
					if(thirdchoice==1) 
					{
						ArrayListSorter.sortArchitecture(architectures, "name");
					}
					if(thirdchoice==2)
					{
						ArrayListSorter.sortArchitecture(architectures, "style");
					}
					if(thirdchoice==0) 
					{
						choice=0;
						break;
					}
					System.out.println(architectures.toString());
				break;
			case 0:
				choice=0;
				break;
				

			default:
				break;
			}
			
			
		}
		else if(choice==2)
		{
			keyboard.nextLine();
			System.out.println("Enter the keyword: ");
			String whattosearchfor=keyboard.nextLine();
			for (Person person : people) 
			{
				if(person.search(whattosearchfor))
					System.out.println(person.toString());
			}
			for (Artwork artwork : artworks) 
			{
				if(artwork.search(whattosearchfor))
					System.out.println(artwork.toString());
			}
			System.out.println("1)Print the lists\n2)Search the vault\n3)Trade\n0)Exit");
			choice=keyboard.nextInt();
	
		}
		else if(choice==3)
		{
			List<Artwork> copyArtworks= new ArrayList<Artwork>();
			for (Artwork artwork : artworks) 
			{
				copyArtworks.add(artwork);
			}
			Trade.startTrade(copyArtworks);
			System.out.println("1)Print the lists\n2)Search the vault\n3)Trade\n0)Exit");
			choice=keyboard.nextInt();
		}
		else {
		System.out.println("1)Print the lists\n2)Search the vault\n3)Trade\n0)Exit");
		choice=keyboard.nextInt();
		}
		
		}
		System.out.println("End of the program");
		keyboard.close();
	}
	
	
	
} 
