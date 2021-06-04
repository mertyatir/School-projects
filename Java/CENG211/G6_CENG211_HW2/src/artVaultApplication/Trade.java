package artVaultApplication;
import java.util.*;

public class Trade 
{
	public static void startTrade(List<Artwork> artworks) 
	{
		Seller seller= new Seller();
		Buyer buyer1= new Buyer();
		Buyer buyer2= new Buyer();
		Buyer buyer3= new Buyer();
		Buyer buyer4=  new Buyer();
		
		
		seller.setPrivateCollection(artworks);
		buyer1.setPrivateCollection(new ArrayList<Artwork>());
		buyer2.setPrivateCollection(new ArrayList<Artwork>());
		buyer3.setPrivateCollection(new ArrayList<Artwork>());
		buyer4.setPrivateCollection(new ArrayList<Artwork>());
		
		seller.setWallet(0);
		buyer1.setWallet(5000000);
		buyer2.setWallet(5000000);
		buyer3.setWallet(5000000);
		buyer4.setWallet(5000000);
		
		
		System.out.println("Seller's  money: "+ seller.getWallet());
		System.out.println("Buyer 1's  money: "+ buyer1.getWallet());
		System.out.println("Buyer 2's  money: "+ buyer2.getWallet());
		System.out.println("Buyer 3's  money: "+ buyer3.getWallet());
		System.out.println("Buyer 4's  money: "+ buyer4.getWallet());
		
		
		
		Random random= new Random();
		int randomInt=random.nextInt(seller.getPrivateCollection().size());
		
		System.out.println("Buyer 1 bought: ");
		
		while(!(seller.getPrivateCollection().get(randomInt).isTradable())) 
		{
			randomInt=random.nextInt(seller.getPrivateCollection().size());
		}
		
		System.out.println(seller.getPrivateCollection().get(randomInt));
		
		
		seller.getPrivateCollection().get(randomInt).tradeToBuyer(buyer1, seller);
		
		randomInt=random.nextInt(seller.getPrivateCollection().size());
		
		System.out.println("Buyer 2 bought: ");
		
		while(!(seller.getPrivateCollection().get(randomInt).isTradable())) 
		{
			randomInt=random.nextInt(seller.getPrivateCollection().size());
		}
		System.out.println(seller.getPrivateCollection().get(randomInt));
		
		seller.getPrivateCollection().get(randomInt).tradeToBuyer(buyer2, seller);
		
		randomInt=random.nextInt(seller.getPrivateCollection().size()-1);
		
		System.out.println("Buyer 3 bought: ");
		
		while(!(seller.getPrivateCollection().get(randomInt).isTradable())) 
		{
			randomInt=random.nextInt(seller.getPrivateCollection().size());
		}
		System.out.println(seller.getPrivateCollection().get(randomInt));
		
		seller.getPrivateCollection().get(randomInt).tradeToBuyer(buyer3, seller);
		
		randomInt=random.nextInt(seller.getPrivateCollection().size()-2);
		
		System.out.println("Buyer 4 bought: ");
		
		while(!(seller.getPrivateCollection().get(randomInt).isTradable())) 
		{
			randomInt=random.nextInt(seller.getPrivateCollection().size());
		}
		System.out.println(seller.getPrivateCollection().get(randomInt));
		
		seller.getPrivateCollection().get(randomInt).tradeToBuyer(buyer4, seller);
		
		
		System.out.println("Trade completed: \n");
		
		System.out.println("Seller's  money: "+ seller.getWallet());
		System.out.println("Buyer 1's  money: "+ buyer1.getWallet());
		System.out.println("Buyer 2's  money: "+ buyer2.getWallet());
		System.out.println("Buyer 3's  money: "+ buyer3.getWallet());
		System.out.println("Buyer 4's  money: "+ buyer4.getWallet());
		

	}
}
