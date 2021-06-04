
public class LinkedStack<T> implements IStack<T>

{
	 Node top; 
	 private class Node 
	 { 
		  
	    T data;
	    Node link; 
	 }
	
	public void push(T newEntry) 
	{
		 Node temp = new Node(); 
		 temp.data = newEntry; 
		 temp.link = top; 
		 top = temp; 
	}

	public T pop() {
        if (isEmpty()) { 
            return null; 
        } 
        else {
        T temp=top.data;
        top = (top).link; 
        return temp;
        }
	}
	
	public T peek() 
	{
        if (!isEmpty()) { 
            return top.data; 
        } 
        else { 
            System.out.println("Stack is empty"); 
            return null; 
        } 
		
	}

	public boolean isEmpty() {
		
		return top == null;
	}
	
	public void clear() 
	{
		this.top=null;
	} 

}
