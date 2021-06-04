package artVaultApplication;

import java.util.List;

public class Painting extends Artwork
{
	private String artist;
	private Float dimension1;
	private Float dimension2;
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Float getDimension1() {
		return dimension1;
	}
	public void setDimension1(Float dimension1) {
		this.dimension1 = dimension1;
	}
	public Float getDimension2() {
		return dimension2;
	}
	public void setDimension2(Float dimension2) {
		this.dimension2 = dimension2;
	}
	
	
	public int compareTo(Object obj, String whatToCompareBy) {
		Painting painting=(Painting)obj;
		if(whatToCompareBy.equals("name")) 
		{
			return this.getName().compareTo(painting.getName());
		}
		else if(whatToCompareBy.equals("style")) 
		{
			return this.getStyle().compareTo(painting.getStyle());
		}
		else if(whatToCompareBy.equals("artist")) 
		{
			return this.getArtist().compareTo(painting.getArtist());
		}
		else 
		{
			return 0;
		}
	}
	
	public float CalculateCost() {
		float area= this.getDimension1()*this.getDimension2();
		float unitPrice;
		String style=this.getStyle();
		if(style.equals("Renaissance")) 
		{
			unitPrice=7;
		}
		else if(style.equals("Baroque"))
		{
			unitPrice=5.5f;
		}
		else 
		{
			unitPrice=4.5f;
		}
			float cost=unitPrice*area;
			
		return cost;
	}
	public String toString() 
	{
		return "Name: "+this.getName()+" Artist: "+this.getArtist()+" Style: "+this.getStyle()+" Dimension1: "+String.valueOf(this.getDimension1())+" Dimension2: "+String.valueOf(this.getDimension2())+"\n";
	}
	
	public boolean search(String whattosearchfor) 
	{
		return this.getArtist().equalsIgnoreCase(whattosearchfor)
				||String.valueOf(this.getDimension1()).equalsIgnoreCase(whattosearchfor)
				||String.valueOf(this.getDimension2()).equalsIgnoreCase(whattosearchfor)
				||this.getName().equalsIgnoreCase(whattosearchfor)
				||this.getStyle().equalsIgnoreCase(whattosearchfor);
	}
	
	public boolean isTradable() 
	{
		if(this.getStyle().equals("Gothic"))
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
