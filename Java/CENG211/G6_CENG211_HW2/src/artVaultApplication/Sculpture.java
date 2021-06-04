package artVaultApplication;
import java.util.*;

public class Sculpture extends Artwork
{
	private String artist;
	private String material;
	private int weight;
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}


	public float CalculateCost() {
		
		float unitPrice;
		String material=this.getMaterial();
		if(material.equals("Marble")) 
		{
			unitPrice=15;
		}
		else if(material.equals("Bronze"))
		{
			unitPrice=180;
		}
		else 
		{
			unitPrice=-1;
		}
			float cost=this.getWeight()*unitPrice;
			
		return cost;
	}

	public int compareTo(Object obj, String whatToCompareBy) 
	{
		Sculpture sculpture=(Sculpture)obj;
		if(whatToCompareBy.equals("name"))
		{
			return this.getName().compareTo(sculpture.getName());
		}
		else if (whatToCompareBy.equals("style")) 
		{
			return this.getStyle().compareTo(sculpture.getStyle());
		}
		else if (whatToCompareBy.equals("artist"))
		{
			return this.getArtist().compareTo(sculpture.getArtist());
		}
		else if (whatToCompareBy.equals("material"))
		{
			return this.getMaterial().compareTo(sculpture.getMaterial());
		}
		else 
		{
		return 0;
		}
	}
	public String toString() 
	{
		return "Name: "+this.getName()+" Artist: "+this.getArtist()+" Style: "+this.getStyle()+" Material: "+this.getMaterial()+" Weight: "+this.getWeight()+"\n";
	}
	
	public boolean search(String whattosearchfor) 
	{
		return this.getArtist().equalsIgnoreCase(whattosearchfor)
				||this.getMaterial().equalsIgnoreCase(whattosearchfor)
				||this.getName().equalsIgnoreCase(whattosearchfor)
				||this.getStyle().equalsIgnoreCase(whattosearchfor)
				||String.valueOf(this.getWeight()).equalsIgnoreCase(whattosearchfor)
				;
	}

	public boolean isTradable() {
		if(this.getStyle().equals("Baroque"))
			return false;
		return true;
	}
	
	public void tradeToBuyer(Buyer buyer, Seller seller) 
	{
		if(isTradable()) 
		{
		List<Artwork> buyeritems=buyer.getPrivateCollection();
		float buyermoney=buyer.getWallet();
		List<Artwork> selleritems=seller.getPrivateCollection();
		float sellermoney=seller.getWallet();
		float cost=CalculateCost();
		for (int i=0;i<selleritems.size()+1;i++) 
		{
			if(selleritems.get(i).getName().equals(this.getName())) 
			{
				buyeritems.add(selleritems.remove(i));
				sellermoney=sellermoney+cost;
				buyermoney=buyermoney-cost;
				buyer.setWallet(buyermoney);
				seller.setWallet(sellermoney);
				break;
			}
		}
		}
	}


	
	
}
