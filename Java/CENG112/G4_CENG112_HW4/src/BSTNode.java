
class BSTNode
 {
     BSTNode left, right;
     IMedia data;
     
     BSTNode(IMedia media)
     {
    	 data=media;
    	 left=null;
    	 right=null;
     }

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public IMedia getData() {
		return data;
	}

	public void setData(IMedia data) {
		this.data = data;
	}
    
	public boolean hasLeft() 
	{
		return left!=null;
	}
	public boolean hasRight() 
	{
		return right!=null;
	}
	
     

 }