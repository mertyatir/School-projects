
public class MarketingAnalyst
{
	IztechPCFactory iztechpcfactory = new IztechPCFactory();
	
	public void order(String product) 
	{
		if(iztechpcfactory.manufacture(product))
		{
			System.out.println("Marketing Analyst requesting "+product.toString()+", SUCCESS, "
					+product.toString()+" manufactured;");
		}
		else 
		{
			System.out.println("Marketing Analyst requesting "+product.toString()+", FAIL, "
					+" Factory line is full");
		}
	}

	public FactoryLine getfactoryline() {
		return iztechpcfactory.getfactoryline();
	}
	

}
