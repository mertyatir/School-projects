import java.util.NoSuchElementException;

public class BST implements IBinarySearchTree<IMedia>
{
	BSTNode root;
	
	public boolean contains(IMedia entry) 
	{
		return getEntry(entry)!=null;
	}


	public IMedia getEntry(IMedia entry) 
	{
		return findEntry(root,entry);
	}

	private IMedia findEntry(BSTNode rootNode, IMedia entry) 
	{
		IMedia result=null;
		if(rootNode!=null) {
		IMedia rootEntry=rootNode.data;
		if(entry.equals(rootEntry))
			result=rootEntry;
		else if(entry.mediaPrice()<rootEntry.mediaPrice())
			result= findEntry(rootNode.left,entry);
		else 
			result= findEntry(rootNode.right,entry);
		}
		return result;
	}


	public IMedia add(IMedia newEntry)
	{
		IMedia result=null;
		if(isEmpty())
			this.root= new BSTNode(newEntry);
		else
			result= addEntry(root,newEntry);
		return result;
	}

	private IMedia addEntry(BSTNode rootNode, IMedia newEntry) 
	{
		assert rootNode!=null;
		IMedia result=null;
		if(newEntry.mediaPrice()==rootNode.data.mediaPrice())
		{
			result=rootNode.data;
			rootNode.setData(newEntry);
		}
		else if(newEntry.mediaPrice()<rootNode.data.mediaPrice())
		{
			if(rootNode.hasLeft())
				result=addEntry(rootNode.getLeft(), newEntry);
			else 
				rootNode.setLeft(new BSTNode(newEntry));		
		}
		
		else if(newEntry.mediaPrice()>rootNode.getData().mediaPrice())
		{
			if(rootNode.hasRight())
				result=addEntry(rootNode.getRight(), newEntry);
			else
				rootNode.setRight(new BSTNode(newEntry));
		}
		return result;
	}


	private boolean isEmpty() {
		return root==null;
	}

	public Iterator<IMedia> getInorderIterator() 
	{
		return new InOrderIterator();
	}


	public IMedia remove(IMedia entry) 
	{
		return null;
	}
	

	
	private class InOrderIterator implements Iterator<IMedia>
	{
		private IStack<BSTNode> nodeStack;
		private BSTNode currentNode;
		
		public InOrderIterator() 
		{	
			this.nodeStack= new LinkedStack<BSTNode>();
			this.currentNode=root;
			
		}
		public boolean hasNext() 
		{
			return !nodeStack.isEmpty()||(currentNode!=null) ;
		}

		
		public IMedia next() 
		{
			BSTNode nextNode=null;
			while(currentNode!=null) {
				nodeStack.push(currentNode);
				currentNode=currentNode.getLeft();
			}
			if(!nodeStack.isEmpty()) {
				nextNode=nodeStack.pop();
				currentNode=nextNode.getRight();
			}
			else
				throw new NoSuchElementException();
			return nextNode.getData();
		}
	}
}