package businessApplication;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Storage<E> {
	
	private Queue<E> storedItem;
	private final static int maxCapacity=10000;
	public Queue<E> getStoredItem() {
		return storedItem;
	}
	public void setStoredItem(Queue<E> storedItem) {
		this.storedItem = storedItem;
	}
	public static int getMaxcapacity() {
		return maxCapacity;
	}
	

	public Storage() 
	{
		storedItem=new ArrayBlockingQueue<E>(maxCapacity);
	}
	public boolean add(E e) {
		return storedItem.add(e);
	}
	public E remove() {
		return storedItem.remove();
	}
	public int size() {
		return storedItem.size();
	}
	public boolean isEmpty() {
		return storedItem.isEmpty();
	}
	public boolean contains(Object o) {
		return storedItem.contains(o);
	}
	public Object[] toArray() {
		return storedItem.toArray();
	}
	public void clear() {
		storedItem.clear();
	}
	public boolean equals(Object o) {
		return storedItem.equals(o);
	}
	public boolean offer(E e) {
		return storedItem.offer(e);
	}
	public E poll() {
		return storedItem.poll();
	}
	public E element() {
		return storedItem.element();
	}
	public E peek() {
		return storedItem.peek();
	}
	public Iterator<E> iterator() {
		return storedItem.iterator();
	}
	public <T> T[] toArray(T[] a) {
		return storedItem.toArray(a);
	}
	public boolean remove(Object o) {
		return storedItem.remove(o);
	}
	public boolean containsAll(Collection<?> c) {
		return storedItem.containsAll(c);
	}
	public boolean addAll(Collection<? extends E> c) {
		return storedItem.addAll(c);
	}
	public boolean removeAll(Collection<?> c) {
		return storedItem.removeAll(c);
	}
	public boolean retainAll(Collection<?> c) {
		return storedItem.retainAll(c);
	}
	public int hashCode() {
		return storedItem.hashCode();
	}
	public String toString() 
	{
		String string="";
		Object[] array=storedItem.toArray();
		for (Object object : array) 
		{
			string=string+object.toString();
		}
		return string;
	}

	


}
