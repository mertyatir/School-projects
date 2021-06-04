package businessApplication;

public interface IControl 
{
		public void transferTo(String itemToBeTransfered, String start,String end,String container) throws ItemNotCountableException,ItemNotUncountableException,DifferentUncountableItemsException;
		public void buyIngredients(int amount,String whichIngredient);
		public void sellProducts(int amount,String whichProduct);
		public void produceProduct(String whichProduct);
		public void printEverything();
	
}
