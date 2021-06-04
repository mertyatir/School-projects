package businessApplication;
import java.util.*;

public class Container<E> {
	private Stack<E> storedItem;
	private final static int maxCapacity= 1000;
	private String location="Factory";
	

	public Stack<E> getStoredItem() {
		return storedItem;
	}



	public void setStoredItem(Stack<E> storedItem) {
		this.storedItem = storedItem;
	}



	public static int getMaxcapacity() {
		return maxCapacity;
	}



	public Container() 
	{
		storedItem= new Stack<E>();
	}


	public boolean addObject(E e)  {
		if(storedItem.size()<maxCapacity) 
		{
		return storedItem.add(e);
		}
	else
	{
		return false;
	}
	}


	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public E peek() {
		return storedItem.peek();
	}



	public E push(E item) {
		return storedItem.push(item);
	}



	public E pop() {
		return storedItem.pop();
	}



	public boolean isEmpty() {
		return storedItem.isEmpty();
	}


	

}
