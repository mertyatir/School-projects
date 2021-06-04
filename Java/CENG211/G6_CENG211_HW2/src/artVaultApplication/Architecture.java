package artVaultApplication;

import java.util.List;

public class Architecture extends Artwork
{
	private Float dimension1;
	private Float dimension2;
	private Float dimension3;
	private String[] architects;
	
	

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
	public Float getDimension3() {
		return dimension3;
	}
	public void setDimension3(Float dimension3) {
		this.dimension3 = dimension3;
	}
	public String[] getArchitects() {
		return architects;
	}
	public void setArchitects(String[] architects) {
		this.architects = architects;
	}
	

	public float CalculateCost() 
	{
		float volume=this.getDimension1()*this.getDimension2()*this.getDimension3();
		float unitPrice;
		String style=getStyle();
		if(style.equals("Gothic"))
			unitPrice=1;
		else if(style.equals("Baroque")) 
		{
			unitPrice=0.8f;
		}
		else
			unitPrice=0.6f;
		return volume*unitPrice;
	}

	public int compareTo(Object obj, String whatToCompareBy) 
	{
		
		Architecture architecture=(Architecture)obj;
		if(whatToCompareBy.equals("name")) 
		{
			return this.getName().compareTo(architecture.getName());
		}
		else if(whatToCompareBy.equals("style")) 
		{
			return this.getStyle().compareTo(architecture.getStyle());
		}
		else 
		{
			return 0;
		}
	}
	public String toString() {
		String temp="";
		for (String string : architects) 
		{
			temp=temp+" "+string;
		}
		return "Name: "+this.getName()+" Style: "+this.getStyle()+" Dimension1: "+String.valueOf(this.getDimension1())+" Dimension2: "+String.valueOf(this.getDimension2())+" Dimension3: "+String.valueOf(this.getDimension3())+" Architects: "+temp+"\n";
	}

	public boolean search(String whattosearchfor) 
	{
		for (String string : architects) 
		{
			if(string.equalsIgnoreCase(whattosearchfor))
				return true;
		}
		return String.valueOf(this.getDimension1()).equalsIgnoreCase(whattosearchfor)
				||String.valueOf(this.getDimension2()).equalsIgnoreCase(whattosearchfor)
				||String.valueOf(this.getDimension3()).equalsIgnoreCase(whattosearchfor)
				||this.getName().equalsIgnoreCase(whattosearchfor)
				||this.getStyle().equalsIgnoreCase(whattosearchfor)
				;
	}

	public boolean isTradable() {
		if(this.getStyle().equals("Renaissance"))
			return false;
		return true;
	}
	public void tradeToBuyer(Buyer buyer, Seller seller) {
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
